class Solution {
    
    static int[] sum;
    private int getSum(int l, int r){
        if(l == 0) return sum[r];
        else return sum[r] - sum[l - 1];
    }
    
    private int solve(int si, int ei, Integer[][] dp){
        if(si > ei) return 0;
        
        if(dp[si][ei] != null) return dp[si][ei];
            
        int total = getSum(si, ei);
        int start = solve(si + 1, ei, dp);
        int end = solve(si, ei - 1, dp);
        
        return dp[si][ei] = total - Math.min(start, end);
    }
    
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        
        sum = new int[n];
        sum[0] = piles[0];
        for(int i = 1; i < n; ++i)
            sum[i] = piles[i] + sum[i - 1];
        
        int total = getSum(0, n - 1);
        Integer[][] dp = new Integer[n][n];
        
        int aliceScore = solve(0, n - 1, dp);
        
        return 2 * aliceScore > total;        
    }
}