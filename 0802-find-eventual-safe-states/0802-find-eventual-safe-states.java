class Solution {
    public int isSafe(int i, int[][] graph, int[] safe){
        if(safe[i] != 0) return safe[i];
        
        safe[i] = -1;
        for(int adj : graph[i]){
            if(isSafe(adj, graph, safe) == -1)
                return safe[i];
        }
        
        return safe[i] = 1;
    }
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<Integer> res = new LinkedList<>();
        int[] safe = new int[graph.length];
        for(int i = 0; i < graph.length; ++i){
            safe[i] = isSafe(i, graph, safe);
            
            if(safe[i] == 1) res.add(i); 
        }
        
        return res;
    }
}