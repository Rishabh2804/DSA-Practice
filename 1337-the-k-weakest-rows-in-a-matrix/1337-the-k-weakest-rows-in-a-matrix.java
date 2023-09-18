class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        int n = mat.length;
        int m = mat[0].length;
        
        int[] count = new int[n];
        
        int j = 0;
        for(int[] row : mat){
            int sol = 0;
            for(int i : row)
                sol += i;
            
            count[j] = sol;
            j++;
        }
        
        int[] weakest = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if(count[a] == count[b]) return b - a;
            else return count[b] - count[a];
        });
        
        for(int i = 0; i < n; ++i){
            pq.add(i);
            if(pq.size() > k) pq.poll();
        }
        
        while(!pq.isEmpty())
            weakest[pq.size() - 1] = pq.poll();
        
        return weakest;
    }
}