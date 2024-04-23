class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> roots = new ArrayList<>();
        
        if(n == 1) {
            roots.add(0);            
            return roots;
        } else if(n == 2) {
            roots.add(0);
            roots.add(1);            
            return roots;
        }
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; ++i) adj.add(new ArrayList<>());
        
        int[] count = new int[n];
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            count[u]++;
            count[v]++;
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        Queue<Integer> leaves = new LinkedList<>();
        for(int i = 0; i < n; ++i) {
            if(count[i] == 1) leaves.add(i);
        }
        
        int nodes = n - leaves.size();
        
        while(nodes > 0) {
            int size = leaves.size();
            while(size --> 0) {
                int curr = leaves.poll();
                
                for(int nbr : adj.get(curr)) { 
                    count[nbr]--;
                    
                    if(count[nbr] == 1) {
                        nodes--;
                        leaves.add(nbr);
                    }
                }
            }            
        }
        
        roots.addAll(leaves);
        return roots;
    }
}