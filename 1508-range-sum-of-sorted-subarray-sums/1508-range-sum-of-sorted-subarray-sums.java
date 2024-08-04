class Solution {
    
    private static final int MOD = 1000000007;
    
    public int rangeSum(int[] nums, int n, int left, int right) {
        
        PriorityQueue<Integer> sums = new PriorityQueue<>();
        for(int i = 0; i < n; ++i){
            
            long sum = 0L;
            for(int j = i; j < n; ++j){
                sum = (0L + sum + nums[j]) % MOD;
                
                sums.add((int)sum);
            }            
        }
                
        int count = right - left + 1;
        while(left --> 1) sums.poll();
        
        long res = 0L;
        while(count --> 0 && !sums.isEmpty()) {
            res = (0L + res + sums.poll()) % MOD;                        
        }
        
        return (int) res;
    }
}