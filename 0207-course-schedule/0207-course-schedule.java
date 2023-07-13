class Solution {
    static final int UNSAFE = -1;
    static final int UNVISITED = 0;
    static final int SAFE = 1;

    public int hasCycle(int i, ArrayList<ArrayList<Integer>> adj, int[] vis){
        if(vis[i] != UNVISITED) return vis[i];
        
        vis[i] = UNSAFE;
        for(int neigh : adj.get(i)){
            if(hasCycle(neigh, adj, vis) == UNSAFE)
                return vis[i];
        }
        
        return vis[i] = SAFE;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; ++i)
            adj.add(new ArrayList<>());
        
        for(int[] pr : prerequisites){
            int u = pr[0];
            int v = pr[1];
            
            adj.get(v).add(u);
        }
        
        int[] vis = new int[numCourses];
                
        for(int i = 0; i < numCourses; ++i){
            vis[i] = hasCycle(i, adj, vis);
            
            if(vis[i] == UNSAFE) return false;
        }
        
        return true;
    }
}