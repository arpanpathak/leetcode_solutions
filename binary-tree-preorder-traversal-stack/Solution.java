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
 * 
 * { @link https://leetcode.com/problems/binary-tree-postorder-traversal }
 */
class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        
        TreeNode ptr = root;
        
        while(ptr !=null || !s.isEmpty()) {
            
            // If we have reached dead end then get the last value out of the stack and add it to result
            if(ptr == null)
               ptr = s.pop();
            
            result.add(0,ptr.val);
            
            // Add left node in stack
            if(ptr.left != null)
                s.push(ptr.left);
            
            // Keep moving right
            ptr = ptr.right;
            
        }
        
        return result;
    }
    
}