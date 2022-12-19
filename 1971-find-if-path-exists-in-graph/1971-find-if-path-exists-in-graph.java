class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        return hasPath(source, destination, adj, new boolean[n]);
    }
    
    public boolean hasPath(int source, int destination, List<List<Integer>> adj, boolean[] visited){
        if(source == destination)
            return true;
        
        if(visited[source])
            return false;
        
        visited[source] = true;
        
        for(int neighbour : adj.get(source)){
            if(!visited[neighbour] && hasPath(neighbour, destination, adj, visited))
                return true;
        }
        
        return false;        
    }
}