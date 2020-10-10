// https://leetcode.com/problems/merge-intervals

class Solution {
    
    public int[][] merge(int[][] intervals) {

        if ( intervals == null || intervals.length == 0)
            return new int[][]{ };

        Arrays.sort(intervals,(a,b)-> a[0] - b[0]);
        int idx = 0;
        
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] > intervals[idx][1]) {
                idx ++;
                intervals[idx]=intervals[i];
            }
            else
                intervals[idx][1] = Math.max( intervals[idx][1],intervals[i][1] );
        }
      
       return Arrays.copyOfRange(intervals, 0,  idx + 1);
        
    }
}