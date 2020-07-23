/***
 * { @link https://leetcode.com/problems/partition-equal-subset-sum/ }
 * 
 * @author Arpan Pathak
 *
***/

class Solution {
    
    public boolean isSubsetSum(int[] nums, int n, int sum) {

        boolean DP[][] = new boolean[n+1][sum + 1];
        
        // For sum 0 with 0th 1st ..... nth element the answer is true because nothing to be included
        for (int i=0 ;i<=n; i++)
            DP[i][0] = true;
        
        // With 0 elements it's not possible to produce subset of any sum. So the answer is false
        for (int i=1 ;i<=sum; i++)
            DP[0][i] = false;
        
        
        // Solbe bottom up for other sub problems
        for(int i=1; i<=n; i++) {
            for (int j=1; j<= sum; j++) {

                // Excluding the ith element. Later it can be modified if we include this item in the subset
                DP[i][j] = DP[i-1][j];
                
                // j > num[i-1] indicates inclusion of ith ement(subtracting 1 because started iterating from 1)
                // is greater than the target sum denoted by current sub problem

                // if the current element is less than the sum then check if there is any subset of currentTargetSum - ith element
                // Other wise store the previously stored value
                if(nums[i-1] <= j) 
                    DP[i][j] = DP[i][j] || DP[i-1][j - nums[i-1] ];
            }
        }
        
        // return the result of actual sub problem
        return DP[n][sum];
    }
    
    public boolean canPartition(int[] nums) {
        
        int sum = 0; 
        
        for (int num: nums)
            sum+= num;
        
        // Odd number can't be split into to equal half. Return false
        if (sum % 2 != 0)
            return false;
        
        // Find if there is any subset X having sum = sum/2 
        // finding subset X implies that there must be the counter part i.e 
        // sum using remaining element is also sum/2
        return isSubsetSum(nums, nums.length, sum/2);
    }
}