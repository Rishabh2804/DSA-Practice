class Solution {
    
    private static final int[][] NONE = new int[0][0];
    
    private int[] getMap(int[] vals){
        if(vals == null) return null;
        int[] map = new int[vals.length];
        for(int i = 0; i < vals.length; ++i){
            map[vals[i]] = i;
        }
        
        return map;
    }
    
    private int[] topoSort(int k, int[][] edges){
        int[] vals = new int[k];
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < k; ++i) adj.add(new ArrayList<>());
        
        int[] in = new int[k];
        for(int[] edge : edges){
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            
            in[v]++;
            
            adj.get(u).add(v);
        }
        
        Queue<Integer> nodes = new LinkedList<>();
        for(int i = 0; i < k; ++i){
            if(in[i] == 0) nodes.add(i);        
        }
        
        int j = 0;
        while(!nodes.isEmpty()){
            int curr = nodes.poll();
            vals[j++] = curr;
            
            for(int nbr : adj.get(curr)){                
                in[nbr]--;
                if(in[nbr] == 0) nodes.add(nbr);                
            }
        }
        
        if(j < k) return null;
        return getMap(vals);
    }
    
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        
        int[] row = topoSort(k, rowConditions);
        int[] col = topoSort(k, colConditions);
        
        if(row == null || col == null) return NONE;
        int[][] mat = new int[k][k];
        for(int i = 0; i < k; ++i){
            int r = row[i];
            int c = col[i];
            
            mat[r][c] = i + 1;
        }
        
        return mat;
    }
}
