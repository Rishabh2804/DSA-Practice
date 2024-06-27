class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] degree = new int[n];
        for(int[] edge : edges){
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            
            degree[u]++;
            degree[v]++;
        }
        
        for(int i = 0; i < n; ++i){
            if(degree[i] == n - 1) return i + 1;
        }
        
        return -1;
    }
}