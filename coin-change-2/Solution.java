/***
 * { @link https://leetcode.com/problems/coin-change-2 }
 * 
 * @author Arpan Pathak
 */
class Solution {
    
    public int change(int amount, int[] coins) {
        int[] dp = new int [amount + 1];
        dp[0] = 1;
        
        return coinChange(amount, coins, dp);
    }
    
    public int coinChange(int amount, int[] coins, int[] dp) {
        
        for(int i =0; i<coins.length ; i++) {
            for(int j= coins[i]; j<=amount; j++)
                dp[j]+=dp[j-coins[i]];
        }
        
        return dp[amount];  
    }
}