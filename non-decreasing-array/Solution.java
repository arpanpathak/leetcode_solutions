/***
 * {@link https://leetcode.com/problems/non-decreasing-array/ }
 */
class Solution {

    public boolean checkPossibility(int[] nums) {
        
        if(nums == null || nums.length <2)
            return true;
        
        int unwanted = -1;

        for(int i = 1; i <nums.length; i++) {
            
            if(nums[i]<nums[i-1]) {
                if(unwanted != -1) 
                    return false;
                
                unwanted = i - 1;
                
            }
        }
        
        if(unwanted == -1)
            return true;
        if( unwanted == 0 || unwanted == ( nums.length -2 ) ) return true;
        
        if(nums[unwanted-1]<= nums[unwanted +1] || nums[unwanted]<= nums[unwanted +2] )
            return true;
        
        return false;
    }
}