class Solution {
    
    private static final int MOD = 1000000007;
    
    private int solve1(int i, int l, int n, int[][] dp){
        if(i >= n) return 1;
        
        if(dp[i][l] != -1) return dp[i][l];
        
        int pres = solve1(i + 1, 0, n, dp);
        int late = 0;
        if(l < 2) late = solve1(i + 1, l + 1, n, dp);
        
        return dp[i][l] = (pres + late) % MOD;
    }
    
    public int checkRecord(int n) {
        
        int[][] dp = new int[n][3];
        for(int[] row : dp) Arrays.fill(row, -1);
        
        long ans = solve1(0, 0, n, dp);
        
        for(int i = 0; i < n; ++i){
            int prev = 1;
            if(i > 0) prev = dp[n - i][0];
            
            int next = 1;
            if(i < n - 1) next = dp[i + 1][0];
            
            long curr = (1L * (prev % MOD) * (next % MOD)) % MOD;
            
            ans = ((ans % MOD) + (curr % MOD)) % MOD;
        }
        
        return (int) (ans % MOD);
    }
}