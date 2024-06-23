class Solution {
                
    public int longestSubarray(int[] nums, int limit) {
        
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();
        
        int maxLen = 1;
        int si = 0;
        for(int i = 0; i < nums.length; ++i){
            while(!min.isEmpty() && nums[min.getLast()] > nums[i]) min.removeLast();
            while(!max.isEmpty() && nums[max.getLast()] < nums[i]) max.removeLast();

            min.addLast(i);
            max.addLast(i);
            
            while(!min.isEmpty() && !max.isEmpty()) {                
                long diff = 0L + nums[min.getFirst()] - nums[max.getFirst()];
                if(Math.abs(diff) <= limit) break;
                
                if(min.getFirst() == si) min.removeFirst();                
                if(max.getFirst() == si) max.removeFirst();
                
                si++;
            }
            
            maxLen = Math.max(maxLen, i - si + 1);
        }
        
        return maxLen;
    }
}