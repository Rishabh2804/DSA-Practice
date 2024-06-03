class Solution {
    
    private int[] size;
    private int[] parent;
    
    private int find(int a){
        
        int p = parent[a];
        if(p != a){
            p = find(p);
        }
        
        return parent[a] = p;
    }
    
    private void union(int a, int b){
        
        int p1 = find(a);
        int p2 = find(b);
        
        if(p1 == p2) return;
        else {
            parent[p1] = p2;
        }        
    }
    
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        
        
        parent = new int[n];
        for(int i = 0; i < n; ++i) parent[i] = i;
        
        size = new int[n];        
        Arrays.fill(size, 1);
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            union(u, v);
        }
        
        int[] cost = new int[n];
        Arrays.fill(cost, -1);
        
        for(int[] edge : edges){
            int u = edge[0];
            int currCost = edge[2];
            
            int p = find(u);
            cost[p] &= currCost;            
        }
        
        int[] res = new int[query.length];
        int i = 0;
        for(int[] q : query){
            int u = q[0];
            int v = q[1];
            
            int p1 = find(u);
            int p2 = find(v);
            
            if(p1 != p2) res[i++] = -1;
            else res[i++] = cost[p1];
        }
        
        return res;
    }
}