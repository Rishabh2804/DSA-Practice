class Solution {
    
    private long getEff(long n, int x){
        if(n >= x) return n % x;
        else return (n + x) % x;        
    }
    
    public int minSubarray(int[] nums, int p) {
        if (p == 1) return 0;
        
        long total = 0;
        for(int i : nums) total += i;
        
        if(total < p) return -1;
                
        int rem = (int)(total % p);
        if (rem == 0) return 0;
                
        int minLen = nums.length;
        
        HashMap<Long, Integer> map = new HashMap<>();            
        long sum = 0;  
        map.put(0L, -1);        
        for(int i = 0; i < nums.length; ++i){
            sum = (0L + sum + nums[i]) % p;
            
            map.put(sum, i);            
            
            long eff = getEff(sum - rem, p);
            if (map.containsKey(eff)) {
                minLen = Math.min(minLen, i - map.get(eff));
            }

        }
        
        if (minLen == nums.length) return -1;
        return minLen;
    }
}