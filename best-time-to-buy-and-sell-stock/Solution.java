/*** 
 * { @link https://leetcode.com/problems/best-time-to-buy-and-sell-stock/ }
 * 
 * @author Arpan Pathak
*/
class Solution {
    
    public int maxProfit(int[] prices) {
        
        if (prices.length == 0)
            return 0;
        
        int maxProfit = 0, minElement = prices[0];
        
        for(int i=1; i<prices.length; i++) {
           
            maxProfit = Math.max(maxProfit, prices[i] - minElement);
            minElement = Math.min(minElement, prices[i]);
        }
        
        return maxProfit;
    }
}