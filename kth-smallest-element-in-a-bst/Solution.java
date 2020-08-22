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
 * {@link https://leetcode.com/problems/kth-smallest-element-in-a-bst}
 */
class Solution {
    
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while ( cur != null || !stack.empty() ) {
            while ( cur!= null ) {
                stack.push(cur);
                cur = cur.left;
            } 
            cur = stack.pop();
            
            if ( --k == 0 )
                return cur.val;
            
            cur = cur.right;
        }
        
        return -1;
    }
}