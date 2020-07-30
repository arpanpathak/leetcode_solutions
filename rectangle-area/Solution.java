/***
 * { @link https://leetcode.com/problems/rectangle-area/ }
 * 
 * @author Arpan Pathak
 */
class Solution {
    
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // Calculate height and width of first rectangle
        int h1 = Math.abs(A-C), w1 = Math.abs(B-D);
        
        // Calculate height and width of 2nd rectangle
        int h2 = Math.abs(E-G), w2 = Math.abs(F-H);
        
        // Calculate height andwidth of intersection....
        int h = Math.min(C,G) - Math.max(A,E);
        int w = Math.min(D, H) - Math.max(B,F);
        int area = h1*w1 + h2*w2;
        
        // If no overlapping b/w two rectangle then return the current area
        if((Math.min(C, G) <= Math.max(A, E)) || (Math.min(D, H) <= Math.max(B, F)) ){
            return  area;
        }

        // subtract overlapping area in order to get total area
        area-= h*w;
        
        return area;
    }
}
