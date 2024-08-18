class Solution {
    
    private static final int[] factors = {2, 3, 5};
    
    private static final List<Integer> res;
    
    static {
        res = new ArrayList<>();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashSet<Integer> vis = new HashSet<>();
        pq.add(1);        
        vis.add(1);        
        
        int n = 1691;
        while(n > 1){
            int curr = pq.poll();            
            res.add(curr);
            
            for(int fact : factors){
                long temp = 1L * curr * fact;
                
                if(temp >= Integer.MAX_VALUE) break;
                
                int curr1 = (int) temp;
                if(!vis.contains(curr1)) {
                    pq.add(curr1);
                    vis.add(curr1);
                }
            }                        
            
            n--;
        }
        
        Collections.sort(res);        
    }
    
    public int nthUglyNumber(int n) {
        
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         pq.add(1);
        
//         HashSet<Integer> vis = new HashSet<>();
//         vis.add(1);        
        
//         while(n > 1){
//             int curr = pq.poll();            
            
//             for(int fact : factors){
//                 long temp = 1L * curr * fact;
                
//                 if(temp >= Integer.MAX_VALUE) break;
                
//                 int curr1 = (int) temp;
//                 if(!vis.contains(curr1)) {
//                     pq.add(curr1);
//                     vis.add(curr1);
//                 }
//             }                        
            
//             n--;
//         }
        
        
        // return pq.poll();
        
        return res.get(n - 1);
    }
}