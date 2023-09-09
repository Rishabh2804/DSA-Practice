class Solution {
    
    private static final boolean canTakeCourse(int courseID, List<List<Integer>> adj, Boolean[] vis){
        
        if(vis[courseID] != null) return !vis[courseID];
        
        vis[courseID] = true;        
        for(int course : adj.get(courseID)){
            
            if(!canTakeCourse(course, adj, vis))
                return false;
        }
        
        vis[courseID] = false;
        return true;
    }
    
    public final boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; ++i)
            adj.add(new ArrayList<>());
        
        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
        }
        
        Boolean[] vis = new Boolean[numCourses];
        for(int i = 0; i < numCourses; ++i){
            if(vis[i] == null){
                if(!canTakeCourse(i, adj, vis)) return false;
            }
        }
        
        return true;
    }
}