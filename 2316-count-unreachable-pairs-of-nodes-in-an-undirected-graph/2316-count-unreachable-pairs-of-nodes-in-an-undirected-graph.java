class Solution {
    public long countPairs(int n, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] visited = new boolean[n];
        int nodesLeft = n;
        long count = 0;
        for(int i = 0; i < n; ++i){
            int compoSize = getComponentSize(i, adj, visited);
            
            long unreachablePair = compoSize;
            unreachablePair *= (nodesLeft - compoSize);
            count += unreachablePair;
            // System.out.println(i + " " + n + " " + compoSize + " " + count);
            nodesLeft -= compoSize;
        }
        
        return count;            
    }
    
    public int getComponentSize(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        
        if(visited[curr])
            return 0;
        
        visited[curr] = true;
        
        int size = 1;
        for(int neighbour : adj.get(curr))
            size += getComponentSize(neighbour, adj, visited);
        
        return size;
    }
}