/***
 * https://leetcode.com/problems/jump-game
 */

class Solution {
    public boolean canJump(int[] nums) {
        
        int end = nums.length -1;
        
        for(int i = nums.length - 1; i>=0; i--) {
            if(i+nums[i] >= end) {
                end = i;
            }
        }
        
        return end == 0;
    }
}