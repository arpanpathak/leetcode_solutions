/***
 * https://leetcode.com/problems/jump-game-ii
 */
class Solution {

    public int jump(int[] nums) {
        // Using breadth first search to and trying to count the max number of levels
        // ans will store the actual jumps require
        int ans = 0, level = 0, currentLevel = 0;
        for(int i=0; i<nums.length; i++) {
            
            // Check if we have reached to index which is greater than i. It means 
            // increase the count and change the level to currentLevel
            if(i>level) {
                ans++;
                level = currentLevel;
            }
            
            // Take the max out of current level or currentIndex + jump at current index
            currentLevel = Math.max(i + nums[i], currentLevel);
        }
        
        return ans;
    }
}