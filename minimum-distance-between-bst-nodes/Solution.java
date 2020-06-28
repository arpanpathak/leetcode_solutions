import java.util.*;
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
 * {@link https://leetcode.com/problems/minimum-distance-between-bst-nodes }
 */
class Solution {

    private int prevs[]={Integer.MAX_VALUE, Integer.MAX_VALUE};
    private int curr = 0, mini = Integer.MAX_VALUE;

    private void inorder(TreeNode ptr)
    {
        if(ptr == null) return;
        inorder(ptr.left);
        
        prevs[curr] = ptr.val;
        curr = (curr+1)%2;
        
        mini = Math.min( mini, Math.abs(prevs[0] - prevs[1]) );
        
        inorder(ptr.right);
    }
        
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return mini;
    }
}