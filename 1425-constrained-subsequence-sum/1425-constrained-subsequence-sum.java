class Solution {
    private static final int VAL = 0;
    private static final int IDX = 1;
    
    public int constrainedSubsetSum(int[] nums, int k) {
        
        int n = nums.length;
//         int[] dq = new int[n];
        
//         int maxSum = 0;
//         for(int i = n - 1; i >= n - k; --i){
//             maxSum = Math.max(maxSum, nums[i]);
            
//             if(i == n - 1)
//                 dq[i] = nums[i];
//             else
//                 dq[i] = Math.max(nums[i], nums[i] + dq[i + 1]);
            
//             maxSum = Math.max(maxSum, dq[i]);
//         }
        
//         for(int i = n - k - 1; i >= k; --i){
            
//         }
        
        // monotonic queue
        
        // Deque
        int maxSum = Integer.MIN_VALUE;
        Deque<int[]> dq = new ArrayDeque<>();
        for(int i = n - 1; i >= 0; --i){
            if(!dq.isEmpty()){
                int[] last = dq.getLast();
                if(last[IDX] > i + k) dq.removeLast();
            }
            
            int max = 0;
            if(!dq.isEmpty())
                max = Math.max(max, dq.getLast()[VAL]);
            
            int curr = Math.max(nums[i], nums[i] + max);
            maxSum = Math.max(maxSum, curr);
            
            while(!dq.isEmpty() && dq.getFirst()[VAL] < curr)
                dq.removeFirst();
                        
            dq.addFirst(new int[]{nums[i] + max, i});
        }
        
        return maxSum;
    }
}