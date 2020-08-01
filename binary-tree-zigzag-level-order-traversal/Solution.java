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
 * { @link https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> temp = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        boolean reverse = false;
        if ( root == null )
            return result;
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()) {
            
            TreeNode front = q.poll();
            
            if(front == null) {
                if (reverse) {
                    Collections.reverse(temp);
                }
                
                result.add(new ArrayList<>(temp));
                temp.clear();
                reverse=!reverse;
                
                if(!q.isEmpty())
                    q.add(null);
                    
            } else {
                temp.add(front.val);
                if ( front.left !=null )
                    q.add(front.left);
                if ( front.right !=null )
                    q.add(front.right);
            }
        }
        
        return result;
        
    }
}