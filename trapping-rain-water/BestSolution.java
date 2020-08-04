/***
 * O(N) solution
 */
class Solution {
    
    public int trap(int[] height) {
        int totalWater = 0, h = height.length;
        int[] leftMax = new int[h], rightMax = new int[h]; 
        
        if ( h == 0 )
            return totalWater;
        
        leftMax[0] = height[0];
        rightMax[h-1] = height[h - 1]; 
        
        for (int i= 1 ; i < h ; i++) 
            leftMax[i] = Math.max( leftMax[i - 1], height[i] );
        
        for (int i= h -2 ; i >=0 ; i--) 
            rightMax[i] = Math.max( rightMax[i + 1], height[i] );
        
        for (int i = 0 ; i < h ; i ++) {
            int minLeftRight = Math.min(leftMax[i], rightMax[i]);
            totalWater += minLeftRight > height[i] ? (minLeftRight - height[i]) : 0;
        }
        
        return totalWater;
        
    }
}