class Solution {
    
    private static final int[] factors = {2, 3, 5};
        
    public int nthUglyNumber(int n) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        
        HashSet<Integer> vis = new HashSet<>();
        vis.add(1);
        
        while(n > 1){
            int curr = pq.poll();            
            
            for(int fact : factors){
                long temp = 1L * curr * fact;
                
                if(temp >= Integer.MAX_VALUE) continue;
                
                int curr1 = (int) temp;
                if(!vis.contains(curr1)) {
                    pq.add(curr1);
                    vis.add(curr1);
                }
            }                        
            
            n--;
        }
        
        return pq.poll();
    }
}