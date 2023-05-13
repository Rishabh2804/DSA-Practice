class Solution {
    static final int mod = 1000000007;
    
    // memoization
    public int solve(int zero, int one, int n, int[] dp){
        if(n < 0) return 0;
        if(n == 0) return 1;
        
        if(dp[n] != -1) return dp[n] % mod;
        
        int ans0 = solve(zero, one, n - zero, dp) % mod;
        int ans1 = solve(zero, one, n - one, dp) % mod;
       
        solve(zero, one, n - 1, dp);
        
        return dp[n] = ((ans0 % mod) + (ans1 % mod)) % mod;
    }
    
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;

        int count = 0;
        int lim1 = Math.min(zero, one);
        int lim2 = Math.max(zero, one);
        
        // tabulation
        for(int i = lim1; i < lim2; ++i)
            dp[i] = (dp[i] + (dp[i - lim1] % mod)) % mod;

        for(int i = lim2; i <= high; ++i){
            dp[i] = (dp[i] + (dp[i - zero] % mod) + (dp[i - one] % mod)) % mod;
            
            if(i >= low) count = (count + (dp[i] % mod)) % mod;
        }
        
        return count;
    }
}