/***
 * { @link https://leetcode.com/problems/rotate-image }
 * 
 * @author Arpan Pathak
 */
class Solution {
    
    void swap(int[][] matrix, int i, int j, int m, int n) {
        int t = matrix[i][j];
        matrix[i][j] = matrix[m][n];
        matrix[m][n] = t;
    }
    public void rotate(int[][] matrix) {
    
        // Transpose
        for(int i=0; i<matrix.length; i++)
            for(int j=i; j<matrix[i].length; j++) 
               swap(matrix, i ,j, j, i);
        
        // Swap columns 
        for(int i=0;i<matrix.length; i++) {
            int l = 0, r = matrix[i].length - 1;
            while(l<r) {
                swap(matrix, i,l, i,r);
                l ++;
                r--;
            }
        }
                
    }
}