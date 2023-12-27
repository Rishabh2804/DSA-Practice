class Solution {
    static final int MOD = 1000000007;
    
    private int ADD(int a, int b){
        return (int)((0l + a + b) % MOD);
    }
    
    private int solve(int i, int k, int target, int[][] dp){
        if (target == dp.length - i) return 1;
        
        if(i >= dp.length) 
            return 0;

        if(dp[i][target] != -1) return dp[i][target];

        dp[i][target] = 0;
        
        for(int j = 1; j <= k; ++j){
            if(j > target) break;
            
            dp[i][target] = ADD(dp[i][target], solve(i + 1, k, target - j, dp));
        }
        
        return dp[i][target] % MOD;        
    }
    
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n][target + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
        
        return solve(0, k, target, dp);
    }
}