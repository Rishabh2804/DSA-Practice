class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i : arr){
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
                 
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (freq.get(a) - freq.get(b)));
        for(Integer key : freq.keySet()) pq.add(key);
        
        while(!pq.isEmpty()){
            int curr = pq.peek();
            if(freq.get(curr) > k) break;
            
            k -= freq.get(curr);
            pq.poll();                
        }
        
        return pq.size();
    }
}