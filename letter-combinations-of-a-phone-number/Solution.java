/***
 * { @link https://leetcode.com/problems/letter-combinations-of-a-phone-number/ }
 * 
 * @author Arpan Pathak
 * 
 */

class Solution {
    
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if ( digits.length() == 0)
            return list;
        
        String mapping[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        generateMappings(digits,0,mapping,"", list);
        
        return list;
    }
    
    void generateMappings(String digits, int i, String[] mapping, String str, List<String> list) {
        
        if (str.length() == digits.length()) {
            list.add(str);
            return ;
        }
        
        for(int x = 0; x< mapping[digits.charAt(i) - '0'].length() ; x++) {
            generateMappings(digits, i + 1, mapping, str + mapping[digits.charAt(i) - '0'].charAt(x), list );
        }
    }
}