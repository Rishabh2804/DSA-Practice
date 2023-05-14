class Solution {
    
    private void traverse(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Queue<Integer> component){
        if(vis[i]) return;
        
        vis[i] = true;
        component.add(i);
        
        for(int neighbour : adj.get(i)) 
            traverse(neighbour, adj, vis, component);
    }
    
    private boolean checkConnected(Queue<Integer> component, ArrayList<ArrayList<Integer>> adj){
        boolean isConnected = true;
        int size = component.size();
        
        while(!component.isEmpty()){
            isConnected &= adj.get(component.poll()).size() == size - 1;
        }
        
        return isConnected;
    }
    
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] vis = new boolean[n];
        Queue<Integer> componentBuffer = new LinkedList<>();
        
        int count = 0;
        for(int i = 0; i < n; ++i){
            if(!vis[i]) {
                traverse(i, adj, vis, componentBuffer);
                
                if(checkConnected(componentBuffer, adj)) count++;
            }
        }
        
        return count;
    }
}