class Solution {
    static final int mod = 1000000007;
    
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
        Arrays.fill(dp, -1);
        
        solve(zero, one, high, dp);
            
        int count = 0;
        for(int i = low; i <= high; ++i){
            if(dp[i] != -1)
                count = ((count % mod) + (dp[i] % mod)) % mod;
        }
        
        return (count % mod);
    }
}