/***
 * { @link https://leetcode.com/problems/greatest-sum-divisible-by-three/ }
 */
class Solution {
    
    public int maxSumDivThree(int[] nums) {

        int sum = 0, sum1 = Integer.MIN_VALUE, sum2 = Integer.MIN_VALUE;

        PriorityQueue<Integer> dp[] = new PriorityQueue[] { 
            new PriorityQueue<>(), new PriorityQueue<>(), new PriorityQueue<>()
        };
        
        for (int num: nums) {
            // Num goes to bucket num % 3
            dp[num % 3].add(num);
            sum+=num;
        }
        
        int k = sum % 3;
        switch (k) {
            case 0:
                return sum;
            case 1:
            case 2:
                if (dp[k].size() > 0)
                    sum1 = sum - dp[k].poll();
                System.out.println(sum1);
                if (dp[3-k].size() > 1)
                    sum2 = sum - dp[3-k].poll() - dp[3-k].poll();
                return Math.max(sum1, sum2);
        }
        
        return sum;
        
    }
}