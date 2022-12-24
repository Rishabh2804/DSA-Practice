class Solution {
    
    public int numTilings(int n) {
        if(n < 3)
            return n;
        
        int mod = 1000000007;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;        
        dp[2] = 2;
        
        for(int i = 3; i <= n; ++i){
            dp[i] = (((2 * dp[i - 1]) % mod) + dp[i - 3]) % mod;
            // for(int j = 0; j <= i - 3; ++j){
            //     dp[i] += (2 * dp[j]) % mod;  
            //     dp[i] %= mod;
            // }
        }
        
        return dp[n];
    }
}