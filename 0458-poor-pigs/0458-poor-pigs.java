class Solution {
    static final int MAX_VALUE = 1000;
    
    private int countBits(int n){
        int count = 0;
        while(n != 0){
            count ++;
            n >>= 1;
        }
        
        return count;
    }
    
    private static final boolean isPowerOf2(int n){
        return (n & (n - 1)) == 0;
    }
    
    private int solve(int buckets, int tests, Integer[][] dp){
        if(buckets <= 1) return 0;
        
        if(tests == 1){
            int ans = countBits(buckets);
            if(isPowerOf2(buckets)) ans --;
            
            return ans;
        }
        
        if(dp[buckets][tests] != null) return dp[buckets][tests];
        
        int ans = MAX_VALUE;
        for(int feed = 1; feed < buckets; ++feed){
            int left = buckets - feed;
            
            int pigs1 = solve(feed, tests - 1, dp); // dead
            int pigs2 = solve(left, tests - 1, dp); // not dead
            
            ans = Math.min(ans, Math.max(1 + pigs1, pigs2));
        }
        
        return dp[buckets][tests] = ans;
    }
    
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int tests = minutesToTest / minutesToDie;
        
        // return solve(buckets, tests, new Integer[buckets + 1][tests + 1]);
        
        int count = 0;
        int ans = 1;
        while(ans < buckets){
            ans *= tests + 1;
            count++;
        }
        
        return count;
    }
}