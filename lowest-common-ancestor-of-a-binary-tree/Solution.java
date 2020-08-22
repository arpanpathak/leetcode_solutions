/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * {@link https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/}
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
    
        TreeNode left = lowestCommonAncestor(root.left, p, q );
        TreeNode right = lowestCommonAncestor(root.right, p, q );
        
        if (left !=null && right!=null)
            return root;
        
        return left!=null ? left : right;  
    }
}