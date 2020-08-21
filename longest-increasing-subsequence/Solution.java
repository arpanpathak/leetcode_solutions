// dp[i] indicates longest increasing sub sequence length where last element is nums[i]
// We can create a top down formula for 
// dp[i] = Max(dp[i], 1 + dp[j]) for all j = 0 to i-1 iff nums[i] > nums[j]
// longest incresing subsequence will be maximum value of nums
/***
 * { @link https://leetcode.com/problems/longest-increasing-subsequence/ }
 */
class Solution {
    
    public int lengthOfLIS(int[] nums) {
        
        int maxLen = 1, len = nums.length; 
        int[] dp = new int[len];
        
        Arrays.fill(dp, 1);
        
        for (int i=1; i<len; i++) {
            for (int j=0; j<i; j++) {
                if(nums[i] > nums[j])  {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    maxLen = Math.max(dp[i], maxLen);
                }
            } 
        }
            
        return len == 0 ? 0 : maxLen;
    }
    
}