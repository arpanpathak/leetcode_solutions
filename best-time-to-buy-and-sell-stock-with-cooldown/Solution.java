/***
 * { @link https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/ }
 */
class Solution {
    
    Map<Integer, Integer> dp = new HashMap<>();
    
    public int maxProfit(int[] prices) {
        
        return getMax(prices, 0);
    }
    
    public int getMax(int[] prices, int i) {
        if (dp.containsKey(i))
            return dp.get(i);
        
        if (i>=prices.length)
            return 0;
        int max =0;
        
        for(int j=i+1; j<prices.length; j++) {
            int m1 = Math.max(prices[j] - prices[i] + getMax(prices, j+2), getMax(prices, j));
            max = Math.max(m1,max);
        }
        
        dp.put(i, max);
        return max;
    }
}