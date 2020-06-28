/***
 * Max area of island
 * 
 * {@link https://leetcode.com/problems/max-area-of-island/ }
 * 
 * @author Arpan Pathak
 */
class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0, M = grid.length, N = grid[0].length;
        for(int i = 0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if ( grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i,j, M, N));
                }
            }
        }
        
        return maxArea;
    }
    
    public int dfs(int[][] G, int i, int j, int M, int N) {
        if(i>=M || j>=N || i<0 || j<0 || G[i][j] == 0)
            return 0;
        
        G[i][j] = 0;
       return 1+ dfs(G, i+1, j, M, N ) + dfs(G, i-1, j, M, N) + dfs(G, i, j+1, M, N) 
               + dfs(G, i, j-1, M, N);
        
        
    }
}