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
 * { @link https://leetcode.com/problems/binary-tree-inorder-traversal }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new LinkedList<>();
        
        TreeNode ptr = root;
        
        while(ptr != null || stack.size() >0) {
            while ( ptr!= null ) {
                stack.push(ptr);
                ptr = ptr.left;
            }
            
            ptr = stack.pop();
            result.add(ptr.val);
            
            ptr = ptr.right;
        }
        
        return result;
    }
}