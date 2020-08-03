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
 * { @link https://leetcode.com/problems/validate-binary-search-tree }
 */
class Solution {

    public boolean isValidBST(TreeNode root) {
        return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean validateBST(TreeNode root, long min, long max) {
        
        return root == null  
                || (root.val < max && root.val > min)
                && validateBST(root.right, root.val, max) 
                && validateBST(root.left, min, root.val);
    }
}