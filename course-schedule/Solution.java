/***
 * { @link https://leetcode.com/problems/course-schedule-ii/ }
 */
class Solution {
    private List<Integer>[] G;
    private boolean[] visited;
    private int[] result;
    private int index = 0;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        init(numCourses, prerequisites);
        if (hasCycle(numCourses))
            return new int[0];
        for ( int i = 0; i< numCourses; i++ ) 
            if (!visited[i])
                dfs(i);
        return result;
        
    }
    
    public void init(int numCourses, int[][] prerequisites) {
        G = new ArrayList[numCourses];
        visited = new boolean[numCourses];
        result = new int[numCourses];
        index = numCourses;
        
        for(int i = 0; i< numCourses; i++)
            G[i] = new ArrayList<>(); 
        
        for(int[] edge: prerequisites)
            G[edge[1]].add(edge[0]);
        
    }
    
    public void dfs(int i) {
        visited[i] = true;
        
        for ( int neighbour: G[i] )
            if (!visited[neighbour] )
                dfs(neighbour);
        result[--index] = i;
    }
    
    public boolean hasCycle(int N) {
        int[] explored = new int[N];
        
        for (int i=0; i<N; i++)
            if (explored[i] == 0)
                if (hasCycleUtil(i, explored))
                    return true;
        return false;
    }
    
    public boolean hasCycleUtil(int i, int[] explored) {
        if (explored[i] == 1)
            return true;
        if (explored[i] == 2)
            return false;
        explored[i] = 1;
        for (int neighbour: G[i]) {
            if (hasCycleUtil(neighbour, explored))
                return true;
        }
        
        explored[i] = 2;
        return false;
    }
}