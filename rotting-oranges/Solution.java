/***
 * Rotting Oranges ( Breadth First Search )
 * {@link https://leetcode.com/problems/rotting-oranges/ }
 *
 * @author Arpan Pathak 
 */
import java.util.*;

class Pos {
    public int x,y;
    public Pos(int x,int y) { this.x = x; this.y =y; }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        
        int[][] offsets = { {0,-1}, {-1,0},{1,0}, {0,1} };
        Queue<Pos> q = new LinkedList<>();
        int ans = 0;
        
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if (grid[i][j] == 2) 
                    q.add(new Pos(i,j));
            }
               
        }
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i =0; i < size; i ++) {
                Pos curr = q.poll();
                for(int[] offset: offsets) {
                    int newX = curr.x + offset[0], newY = curr.y + offset[1];

                    // Checking if Adjacent affected co-ordinate is not out of bound
                    if(
                        newX>=0 && newX<grid.length 
                        && newY >=0 && newY <grid[0].length 
                        && grid[newX][newY] == 1
                    ) 
                    {
                        
                        grid[newX][newY] = 2;
                        q.add(new Pos(newX,newY));
                    }
                }

            }
            
            ans+=q.size() > 0 ? 1 : 0;
            
        }
        
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) 
                    return -1;
            }
               
        }
        
        return ans;
    }
    
}