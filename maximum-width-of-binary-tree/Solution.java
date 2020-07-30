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
 * { @link https://leetcode.com/problems/maximum-width-of-binary-tree }
 * 
 * @author Arpan Pathak
 */
class Solution {

    class Node {
        TreeNode node;
        int index;
        public Node(TreeNode node, int index) { this.node = node; this.index = index; }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> q = new LinkedList<>();
        int si=Integer.MAX_VALUE, ei = Integer.MIN_VALUE, maxWidth = Integer.MIN_VALUE;
        
        q.add(new Node(root, 0));
        q.add(null);
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            
            // Reached end of the level
            if (curr == null) {
                // calculate max width by start and end indices of this level
                maxWidth = Math.max(maxWidth, ei - si + 1);
                
                // reset indices 
                ei = Integer.MIN_VALUE; si = Integer.MAX_VALUE;

                // If some values are there in the tree then add end label null marker to them
                if(!q.isEmpty())
                    q.add(null);
            } else {
                
                si = Math.min(si, curr.index);
                ei = Math.max(ei, curr.index);
                
                // Add to queue if left child exist with index 2*curr.index  + 1
                if(curr.node.left != null) 
                    q.add(new Node(curr.node.left, 2*curr.index + 1));
                
                // Add to queue if right child exist with index 2*curr.index  + 2
                if(curr.node.right != null) 
                    q.add(new Node(curr.node.right, 2*curr.index + 2));
                
            }
        }
        
        return maxWidth;
    }
}