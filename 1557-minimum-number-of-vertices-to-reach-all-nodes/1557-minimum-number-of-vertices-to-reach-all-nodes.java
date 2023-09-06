class Solution {

    private void traverse(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        if(vis[curr]) return;
        
        vis[curr] = true;            
        
        for(int nbr : adj.get(curr)){
            traverse(nbr, adj, vis);
        }
    }
    
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        HashSet[] inDegrees = new HashSet[n];
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());
        
        for(List<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);
            
            adj.get(u).add(v);            
        }
        
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; ++i){
            if(!vis[i]) {
                traverse(i, adj, vis);
                vis[i] = false;
            }
        }
        
        List<Integer> vertices = new ArrayList<>();        
        for(int i = 0; i < n; ++i){
            if(!vis[i]) vertices.add(i);
        }
        
        return vertices;
    }
}