/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * {@link https://leetcode.com/problems/longest-univalue-path }
 */
class Solution {
    private int longestPath = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        getPathLength(root);
        return longestPath;
    }
    
    private int getPathLength(TreeNode ptr) {
        if(ptr == null) return 0;
        int left = getPathLength(ptr.left);
        int right = getPathLength(ptr.right);
        
        if(ptr.left !=null && ptr.left.val == ptr.val)
            left ++;
        else 
            left = 0;
        
        if(ptr.right !=null && ptr.right.val == ptr.val)
            right ++;
        else 
            right = 0;
        
        longestPath = Math.max(longestPath, left + right);
        return Math.max(left,right);
    }
}