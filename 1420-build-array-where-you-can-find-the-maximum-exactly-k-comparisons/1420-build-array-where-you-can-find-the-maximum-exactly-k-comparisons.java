class Solution {
    
    static final int MOD = 1000000007;
        
    static final int ADD(int a, int b){
        return ((a % MOD) + (b % MOD)) % MOD;
    }
    
    private int solve(int n, int l, int m, int k, Integer[][][] dp){
        
        if(n <= 0) return 0;
        if(n == 1) {
            if (k == 0) return l;
            else if(k == 1) return (m - l);
            else return 0;
        }
        
        if(dp[n][l][k] != null) return dp[n][l][k];
        
        int ans = 0;
        for(int i = 1; i <= l; ++i){
            // smaller values can be inserted, which would produce no change in max_index
            // hence cost would not reduce
            // Thus, range would be [1, l]
            // no cost changes --> k = k
            // no change in max_index --> l = l
            ans = ADD(ans, solve(n - 1, l, m, k, dp));
        }
        
        if(k > 0){
            for(int i = l + 1; i <= m; ++i){
                ans = ADD(ans, solve(n - 1, i, m, k - 1, dp));
            }
        }
        
        return dp[n][l][k] = ans;
    }
    
    public int numOfArrays(int n, int m, int k) {        
        return solve(n, 0, m, k, new Integer[n + 1][m + 1][k + 1]);
    }
}