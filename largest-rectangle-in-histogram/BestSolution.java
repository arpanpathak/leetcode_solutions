class BestSolution {
    
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>(); 
        int maxArea = 0, top, n= heights.length, width;
       
        int i = 0; 
        while (i < n || !s.empty()) 
        { 
            if ( i<n && (s.empty() || heights[s.peek()] <= heights[i]) ) 
                s.push(i++); 
            else
            { 
                top = s.pop();
                width = s.empty() ? i : i - s.peek() - 1;
                maxArea = Math.max ( maxArea, heights[top] * width  );
            } 
        } 
       
        return maxArea; 
    }
}