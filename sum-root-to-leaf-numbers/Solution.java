/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * {@link https://leetcode.com/problems/sum-root-to-leaf-numbers/ }
 * }
 */
class Solution {
    int s =0;
    public int sumNumbers(TreeNode root) {

     getSum(root, 0);
     return s;
        
    }
    
    public void getSum(TreeNode root,int sum) {
        if(root == null) {
            return ;
        }
    
        int sumSoFar = sum *10 + root.val;
        
        if(root.left == null && root.right == null) {
            s += sumSoFar;
            return;
        }
        
        getSum(root.left, sumSoFar);
    
        getSum(root.right, sumSoFar);
    
    }
}