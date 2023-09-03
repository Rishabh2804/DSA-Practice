class Solution {
    private int solve(int i, int j, Integer[][] dp){
        if(i >= dp.length || j >= dp[0].length) return 0;
        
        if(i == dp.length - 1 && j == dp[0].length - 1) return 1;        
 
        if(dp[i][j] != null) return dp[i][j];
        
        int right = solve(i, j + 1, dp);
        int down = solve(i + 1, j, dp);
        
        return dp[i][j] = right + down;
    }
    
    public int uniquePaths(int m, int n) {
        Integer[][] dp = new Integer[m][n];            
        return solve(0, 0, dp);
    }
}