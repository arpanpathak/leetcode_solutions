/***
 * { @link https://leetcode.com/problems/cherry-pickup/ }
 * 
 * @author Arpan Pathak
 */
class Solution {
    
    public int cherryPickup(int[][] grid) {
		int n = grid.length;
		int[][][] dp = new int[n][n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                for(int k=0;k <n; k++)
                    dp[i][j][k] = Integer.MIN_VALUE;
		return Math.max( 0, dfs(grid, n, 0, 0, 0 , dp) );
	}

	private int dfs(int[][] grid, int n, int r, int c1, int c2, int[][][] dp) {
    
        // r1 + r2 = c1 + c2
        int r2 = r + c1 - c2;
		if (r>=n|| r2>=n || c1>=n || c2>=n || grid[r][c1] == -1 || grid[r2][c2] == -1) 
            return Integer.MIN_VALUE;
        // If already computed then return the result....
        if (dp[r][c1][c2] != Integer.MIN_VALUE) 
            return dp[r][c1][c2];
		
        // We reached the end..
        if (r == n - 1 && c1 == n - 1) return grid[r][c1];
        
        int ans = c1!=c2 ? grid[r][c1] + grid[r2][c2] : grid[r][c1];
        
		int temp = Math.max( dfs(grid, n , r, c1 +1, c2+1, dp  ), dfs(grid, n, r, c1 +1, c2, dp  ) );
        temp = Math.max( temp, dfs(grid, n, r + 1, c1, c2, dp  ));
        temp  = Math.max( temp, dfs(grid, n, r+1, c1, c2 + 1, dp  ) );
        
        ans+=temp;
        dp[r][c1][c2] = ans;
		return ans;
	}
}