/***
 * Longest Palindromic Substring 
 * {@link https://leetcode.com/problems/longest-palindromic-substring/ }
 *
 * @author Arpan Pathak
 */
class Solution {
    
    public String longestPalindrome(String s) {
        int left=0,right =0;
        if(s == null || s.length() ==0)
            return "";
        
        for(int i=0; i<s.length(); i++) {
            int currLen = Math.max(longestLength(s,i,i), longestLength(s,i,i+1));
            
            if(currLen> right - left) {
                left = i - (currLen - 1)/2;
                right = i + currLen/2;
            }
        }
        
        return s.substring(left,right +1);
    }
    
    public int longestLength(String s, int left, int right) {
        if(s == null || left > right) return 0;
        
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right ++;
        }
        
        return right - left -1;
    }
}