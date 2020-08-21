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
 * Solution::iterative inorder traversal using stack
 * 
 * {@link https://leetcode.com/problems/all-elements-in-two-binary-search-trees}
 */
class Solution {
    
    public void inOrderTraversal(TreeNode root, PriorityQueue<Integer> pq) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        
        while ( cur != null || !stack.empty() ) {
            while ( cur!= null ) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            pq.add(cur.val);
            cur = cur.right;
        }
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> result = new LinkedList<>();
        inOrderTraversal(root1, pq);
        inOrderTraversal(root2, pq);
        
        while (!pq.isEmpty())  
            result.add(pq.poll());
        
        return result;
    }
}