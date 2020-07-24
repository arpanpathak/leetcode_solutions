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
 * { @link https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree }
 * 
 * @author Arpan Pathak
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List< List<Integer> > result = new ArrayList<>();

        // TreeMap stores x axis as key and list of pair where first item is the level and 2nd is the value
        // All the keys are sorted in TreeMap so items will be sorted as per x axis
        Map<Integer, List<int[]>> m = new TreeMap<>();
        
        // DFS to recursively find verticle order
        findVerticleOrder(root, m, 0, 0);
        
        for( List<int[]> list: m.values() ) {
            
            // If both values are not same then sort by their level
            Collections.sort(list, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);

            List<Integer> ordered = new ArrayList<>();
            for (int[] arr : list) 
                ordered.add(arr[1]);
            result.add(ordered);
        }
        
        return result;
          
    }
    
    // Recursively build the map
    void findVerticleOrder(TreeNode node, Map<Integer, List<int[]>> m, int v, int level) {
        
        if ( node == null )
            return;
        
        m.computeIfAbsent(v, list -> new ArrayList<>())
         .add(new int[] {level, node.val});
        
        // X axis for left subtree is current x axis -1
        findVerticleOrder(node.left,m, v-1, level+1 );

        // x axis for right subtree is current x axis + 1
        findVerticleOrder(node.right,m, v+1, level+1 );
    }
}