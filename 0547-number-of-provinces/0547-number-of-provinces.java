class Solution {
    private void traverse(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        
        if(vis[curr]) return;
        
        vis[curr] = true;
        for(int nbr : adj.get(curr))
            traverse(nbr, adj, vis);
                
    }
    
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(i == j) continue;
                
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        boolean[] vis = new boolean[n];
        
        int count = 0;
        for(int i = 0; i < n; ++i){
            if(!vis[i]){
                count++;
                traverse(i, adj, vis);
            }
        }
        
        return count;
    }
}