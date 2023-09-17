class Solution {
    static final int NODE = 0;
    static final int COST = 1;
    static final int MASK = 2;
    
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int destMask = (1 << n) - 1;
        
        HashSet[] visPaths = new HashSet[n];

        Queue<int[]> nodes = new LinkedList<>();
        for(int i = 0; i < n; ++i){
            int node = i;
            int cost = 0;
            int mask = (1 << i);
            
            nodes.add(new int[]{node, cost, mask});
            
            visPaths[i] = new HashSet<Integer>();
            visPaths[i].add(mask);                 
        }        
        
        while(!nodes.isEmpty()){
            
            int[] curr = nodes.poll();
            int node = curr[NODE];
            int cost = curr[COST];
            int mask = curr[MASK];
            
            if(mask == destMask) return cost;            
            
            for(int nbr : graph[node]){
                int postMask = mask | (1 << nbr);                
                if(visPaths[nbr].contains(postMask)) continue;

                int postCost = cost + 1;
                nodes.add(new int[]{nbr, postCost, postMask});
                
                visPaths[nbr].add(postMask);
            }
        }
        
        return 0;
    }
}