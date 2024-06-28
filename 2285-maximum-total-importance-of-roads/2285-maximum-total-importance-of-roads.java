class Solution {
    public long maximumImportance(int n, int[][] roads) {
        HashMap<Integer, Integer> values = new HashMap<>();
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; ++i) adj.add(new ArrayList<>());
        
        int[] degree = new int[n];
        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> adj.get(b).size() - adj.get(a).size());
        for(int i = 0; i < n; ++i) pq.add(i);
        
        long total = 0;
        int val = n;
        while(!pq.isEmpty()){
            int curr = pq.poll();
            
            
            int rem = adj.get(curr).size();
            total += 1l * val * rem;
            val--;
        }
        
        return total;
    }
}