class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int totalTime = solve(0, -1, adj, hasApple);
                
        return (totalTime == -1) ? 0 : totalTime;
    }
    
    private int solve(int v, int parent, List<List<Integer>> adj, List<Boolean> hasApple){
        
        int time = -1; // initally set to -1 to denote no apple node exists in this subtree
        for(int child : adj.get(v)){
            if(child == parent)
                continue;
            
            int childTime = solve(child, v, adj, hasApple); 
            if(childTime != -1)
                time += 2 + childTime;
        }
                
        if(time != -1) // has atleast one apple node
            time++;    // increment to compensate for initial -1
        else if(hasApple.get(v)) // no child apple node, but root itself has an apple
            time++;
        
        return time;
    }
}