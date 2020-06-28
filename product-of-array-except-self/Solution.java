/***
 * {@link https://leetcode.com/problems/product-of-array-except-self/ }
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroes = 0, product = 1, N = nums.length;
        int[] productArray = new int[N];
        
        for (int num : nums) {
            if (num == 0) 
                zeroes ++;
            else 
               product*= num; 
        }
        
        for (int i = 0; i<N; i++) {
            if (nums[i] == 0 && zeroes == 1) 
                productArray[i] = product;
            else if(nums[i] == 0 || zeroes >= 1)
                productArray[i] = 0;
            else
                productArray[i] = product / nums[i];
        }
        
        return productArray;
    }
}