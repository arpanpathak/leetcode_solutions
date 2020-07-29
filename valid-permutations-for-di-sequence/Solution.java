/***
 * { @link https://leetcode.com/problems/valid-permutations-for-di-sequence }
 * 
 * @author Arpan Pathak
 */

class Solution {
    public int numPermsDISequence(String S) {
        List<Long> dp1 = new ArrayList<>();
        dp1.add(0L);
        dp1.add(1L);
    
        for (int l = 0; l < S.length(); l++) {
            List<Long> dp2 = new ArrayList<>();
            dp2.add(0L);
            
            for (int x = 0; x <= l + 1; x++) {
                
                long curr = S.charAt(l) == 'D' ? dp1.get(x) : dp1.get(l + 1) - dp1.get(x);
                
                dp2.add((dp2.get(dp2.size() - 1) + curr + 1000000007) % 1000000007);
            }
            
            dp1 = dp2;
        }
        
        long res = (dp1.get(S.length() + 1));
        return (int)res;
    }
}