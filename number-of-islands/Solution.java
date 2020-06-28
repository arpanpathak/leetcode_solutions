/***
 * {@link https://leetcode.com/problems/number-of-islands/ }
 */
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int M = grid.length, N = grid[0].length;
        int count = 0;
        char lastSeen = grid[0][0];
        for (int i = 0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if (grid[i][j]== '1') {
                    count+= dfs(grid,i,j,M,N);
                }
            }
        }
        
        return count;
    }
    
    public int dfs(char[][] G, int i, int j, int M, int N) {
        if(i>=M || j>=N || i<0 || j<0 || G[i][j] == '0')
            return 0;
        
        G[i][j] = '0';
        
        dfs(G, i+1, j, M, N);
        dfs(G, i-1, j, M, N);
        dfs(G, i, j+1, M, N);
        dfs(G, i, j-1, M, N);
        
        return 1;
        
    }
}