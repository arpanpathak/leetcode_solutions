/***
 * https://leetcode.com/problems/trapping-rain-water
 * 
 * @author Arpan Pathak
 */
class Solution {
    
    public int trap(int[] height) {
        int totalWater = 0;
        
        for(int i=0; i<height.length; i++) {
           
            int maxLeft = height[i], maxRight = height[i];
            
            // Find highest bar in left
            for(int l=i-1; l>=0; l--)
                maxLeft = Math.max(maxLeft,height[l]);
            
            // Find highest bar in right
            for(int r=i+1; r<height.length; r++)
                maxRight = Math.max(maxRight,height[r]);
        
            // take the lower among maxLeft and maxRight and calculate the amount of water above current bar
            totalWater+= (Math.min(maxLeft, maxRight) - height[i] );
            
        }
        
        return totalWater;
        
    }
}