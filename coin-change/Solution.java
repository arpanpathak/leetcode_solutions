/***
 * { @link https://leetcode.com/problems/coin-change/ }
 * 
 * @author Arpan Pathak
 * 
 */
class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Arrays.sort(coins);
        
        return coinChange(coins,amount, dp);
    }
    
    public int coinChange(int[] coins, int amount, int[] dp) {
        
        for(int i=1; i<=amount; i++) {
            for(int j=0; j<coins.length && coins[j]<=i; j++)
                if (dp[i - coins[j]] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], 1+ dp[i - coins[j]]);
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}