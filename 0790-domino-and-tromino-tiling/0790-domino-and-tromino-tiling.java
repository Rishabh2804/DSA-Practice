class Solution {
    static int mod = 1000000007;
    
    public int numTilings(int n) {
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;        
        
        for(int i = 2; i <= n; ++i){
            dp[i] = ((dp[i - 1] % mod) + (dp[i - 2] % mod)) % mod;
            for(int j = 0; j <= i - 3; ++j){
                dp[i] += (2 * dp[j]) % mod;  
                dp[i] %= mod;
            }
        }
        
        return dp[n];
    }
}