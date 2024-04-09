class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < tickets.length; ++i) queue.add(i);
        
        int time = 0;
        while(!queue.isEmpty()){
            time ++;
            int curr = queue.poll();
            tickets[curr] --;
            
            if(tickets[curr] > 0) queue.add(curr); 
            else if(curr == k) return time;
        }
        
        return time;
    }
}