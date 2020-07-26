/***
 * { @link https://leetcode.com/problems/super-egg-drop/ }
 * 
 * @author Arpan
 */
class Solution {
    public int superEggDrop(int K, int N) {
        int DP[][] = new int[N+1][K+1];
       
        for (int i=1; i<=K; i++) {
            // For 0 floor 0 tries required, for 1 floors 1 try is required no matter how many
            DP[0][i] = 0;
            DP[1][i] = 1;
        }
        
        // With 1 egg, number of tries required is equals to the number of floors
        for (int i=1; i<=N; i++) {
            DP[i][1] = i;
        }
        
        for (int i = 2; i<= N; i++) {
            for (int j = 2; j<=K; j++) {
                
                // Apply binary search to find a point where we can optimally drop the egg
                int left = 1;
                int right = i;
                while(left <= right){
                    int mid = (left + right) / 2;
                    int dp1 = DP[mid - 1][j - 1];
                    int dp2 = DP[i - mid][j];
                    if(dp1 >= dp2){
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
                }
                    
                // Take the max out of two possibilities
                DP[i][j] =  1 + Math.max(DP[left-1][j-1], DP[i - left][j]);
                
            }
        }
        
        return DP[N][K];
    }
    
   
}