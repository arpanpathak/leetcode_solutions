/***
 * { @link https://leetcode.com/problems/critical-connections-in-a-network/ }
 * 
 * @author Arpan Pathak
 */
class Solution {
    private List<Integer>[] G;
    private List<List<Integer> > result  = new ArrayList<>();
    private boolean[] visited;
    private int[] label, low;
    private int depth = 0;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        G = new ArrayList[n];
        label = new int[n];
        low = new int[n];
        visited = new boolean[n];
        
        for (int i = 0; i<n; i++)
            G[i] = new ArrayList<>();
       
        // Create adjacency list
        for(List<Integer> edge: connections) {
            int i = edge.get(0), j = edge.get(1);
            G[i].add(j);   G[j].add(i);  
        }

        // DFS to find low and label for all nodes
        dfs(connections, 0, -1);
    
        return result;
    }
    
    void dfs(List<List<Integer>> connections, int node, int parent) {
        visited[node] = true;
        label[node] = depth;
        low[node] = depth ++;
        
        for (int neighbour: G[node]) {

            if (neighbour == parent) 
                continue;
            // If neighbour is not visited then DFS and compute it's low
            if(!visited[neighbour]) {

                dfs(connections, neighbour, node);
                
                // Set low of current node to the minimum value obtained after DFS
                low[node] = Math.min(low[node], low[neighbour]);

                // If low of neighbour is greater than current node it means there is a no path back
                // to the current node. It implies deleting the connection (node, neighbour) will
                // disconnect the graph. So it must be one of the critical connection
                if ( label[node] < low[neighbour] ) 
                    result.add(Arrays.asList(node, neighbour));
            } else {

                // else take the lowest value of low and copy that to node
                low[node] = Math.min(low[node], low[neighbour]);
            }
        }
        
    }
   
}