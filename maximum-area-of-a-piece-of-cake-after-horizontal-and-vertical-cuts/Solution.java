/***
 * { @link https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts }
 * 
 * @author Arpan Pathak
 */
class Solution {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        return (int) ( (maxDiff (horizontalCuts, h) * maxDiff(verticalCuts, w)) %1000000007 );        
    }
    
    public long maxDiff(int[] A, int M) {
        Arrays.sort(A);
        int max = 0, prev = 0;
        
        for(int i: A) {
            max = Math.max(max, i - prev );
            prev = i;
        }
        
        return Math.max(max, M - prev);
    }
}