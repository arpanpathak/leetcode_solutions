/***
 * { @link https://leetcode.com/problems/online-stock-span }
 * 
 * @author Arpan Pathak
 */
class StockSpanner {
    
    Stack<int[]> s;
    public StockSpanner() {
        s = new Stack<>();
    }
    
    public int next(int price) {

        int span = 1;
        if ( s.isEmpty() ) {
            s.add(new int[]{price, 1});
        } else {
            while(!s.isEmpty() && s.peek()[0] <=price ) {
                int[] prev = s.pop();
                span+=prev[1];
            }
            
            s.add(new int[]{price, span});
        }
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */