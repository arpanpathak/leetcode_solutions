/***
 * { @link https://leetcode.com/problems/longest-substring-without-repeating-characters }
 * 
 * @author Arpan Pathak
 */
class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        
        int len = 0, n = s.length(), index = 0;
        int[] last = new int[256];
        Arrays.fill(last, -1);
        
        for(int i=0; i<n; i++) {
            index = Math.max(index, last[s.charAt(i)] + 1);
            
            len = Math.max(len, i - index + 1);
            
            last[s.charAt(i)] = i;
        }
        
        return len;
    }
}