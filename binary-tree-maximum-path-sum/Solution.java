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
 * {@link https://leetcode.com/problems/binary-tree-maximum-path-sum }
 */
class Solution {
    
    private int ans = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
       getMaxPathSum(root);
        
        return ans;
    }
    
    private int getMaxPathSum(TreeNode root) {
        
        if(root == null) 
            return 0;
        
        int left =  getMaxPathSum(root.left);
        int right = getMaxPathSum(root.right);
        int currentMax= Math.max( Math.max(left, right) + root.val , root.val );
        int maxSoFar = Math.max( currentMax, left + right + root.val);
        ans = Math.max (maxSoFar, ans);
        
        return currentMax;
    }
}