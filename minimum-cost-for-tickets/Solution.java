/***
 * { @link  https://leetcode.com/problems/minimum-cost-for-tickets/ }
 * 
 * @author Arpan Pathak
 */
class Solution {

    private int[][] dp = null; 
    public int mincostTickets(int[] days, int[] costs) {
        
        dp = new int[days.length][366];
        for(int i=0; i<days.length; i++)
            Arrays.fill(dp[i], -1);
        
        // Top down memorization 
        return getMin(days, costs, 0, 0);
            
    }
    
    public int getMin(int[] days, int[] costs, int i, int expiry) {

        if ( i== days.length || expiry > 365 )
            return 0;
        
        if (dp[i][expiry] != -1)
            return dp[i][expiry];
        
        if( expiry>= days[i] )
            return getMin(days,costs, i + 1,expiry);
        
         dp[i][expiry] = Math.min(
             costs[0] + getMin(days, costs, i + 1, days[i] ),
             Math.min (
                 costs[1] + getMin(days, costs, i + 1, days[i] + 6 ),
                 costs[2] + getMin(days, costs, i + 1, days[i] + 29 )
             )  
        );
        
        return dp[i][expiry];
            
    }
    
}