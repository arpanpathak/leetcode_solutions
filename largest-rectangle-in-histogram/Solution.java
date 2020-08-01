/***
 * { @ https://leetcode.com/problems/largest-rectangle-in-histogram/ }
 * 
 * Naive approach
 */
class Solution {
    
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        
        for ( int i=0 ; i<heights.length ; i++) {
            int m = i, n=i;
            while (m>=0 && heights[m] >= heights[i] )
                m--;
            
            while ( n < heights.length && heights[n] >= heights[i])
                n++;
            max = Math.max( max , m==n ? heights[i]: (n - m -1)*heights[i] );
            
        }
        
        return max;
    }
}