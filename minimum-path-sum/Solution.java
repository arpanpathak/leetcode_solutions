/***
 * Minimum Path Sum ( Dynamic Programming )
 * {@link https://leetcode.com/problems/minimum-path-sum/ }
 * @author Arpan Pathak 
 */
class Solution {
    public int minPathSum(int[][] grid) {
        if ( grid == null || grid.length == 0)
            return 0;
        
       int m = grid.length, n = grid[0].length;
        
        int[][] dp = new int[m][n];
        
        for(int i = 0 ;i <m; i++) {
            for(int j=0; j<n; j++) {
                dp[i][j] += grid[i][j];
                
                if (i>0 && j>0) {
                    dp[i][j] += Math.min(dp[i-1][j],dp[i][j-1]);
                } else if(i>0) {
                    dp[i][j]+=dp[i-1][j];
                } else if(j>0) {
                    dp[i][j]+=dp[i][j-1];
                }
            }
        }
        
        return dp[m-1][n-1];
        
    }
}