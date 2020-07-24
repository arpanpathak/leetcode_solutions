/***
 * {@link https://leetcode.com/problems/spiral-matrix/ }
 * 
 * @author Arpan Pathak
 * 
 ***/
 
class Solution {

    /**
     * The idea is to take four corner and first printing in the following order first row,last column,last row then
     * first column
     * 
     * @param matrix
     * @return List<Integer> spiral order
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (matrix.length == 0) return result;
        
        int m = matrix.length, n = matrix[0].length;
        
        int fr = 0, lr = m-1, fc=0, lc = n -1, count = 0;
        
        while ( fr<=lc && fc<= lc ) {
            
            // print first row
            for(int i=fc; i<=lc; i++) {
                result.add(matrix[fr][i]);  
                
                count++;
            }
            fr++;
            
            if(count == m*n) return result;
            
            // print last column
            for(int i=fr; i<=lr; i++) {
                result.add(matrix[i][lc]);
                count++;
                
            }
            lc--;
            
            if(count == m*n) return result;
            
            //print last row
             for(int i=lc; i>=fc; i--) {
                result.add(matrix[lr][i]);  
                
                count++;
            }
            
            lr--;
            
            if(count == m*n) return result;
            
            // print first column
            for(int i=lr; i>=fr; i--) {
                result.add(matrix[i][fc]);
                count++;
                
            }
            fc++;
            
            if(count == m*n) return result;
        }
        
        return result;
    }
}