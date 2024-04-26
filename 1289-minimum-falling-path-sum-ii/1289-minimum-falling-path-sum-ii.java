class Solution {
    
    private static final int START = -1;
    private static final int MAX = 50000;
    private static final int NONE = -1 * MAX;
    
    private int solve(int r, int c, int[][] grid, int[][] dp){
        if(r >= grid.length) return 0;
        
        if(dp[r][c] != NONE) return dp[r][c];
        
        int n = grid.length;
        int minSum = MAX;
        
        for(int j = 0; j < n; ++j){
            if(j == c) continue;
            
            int sum = grid[r][j] + solve(r + 1, j, grid, dp);
            minSum = Math.min(minSum, sum);            
        }
        
        return dp[r][c] = minSum;
    }
    
    public int minFallingPathSum(int[][] grid) {
        
        int n = grid.length;
        
        int[][] dp = new int[n][n];
        for(int[] row : dp) Arrays.fill(row, NONE);
        
        int minSum = MAX;
        for(int i = 0; i < n; ++i){
            int sum = grid[0][i] + solve(1, i, grid, dp);
            minSum = Math.min(minSum, sum);
        }
        
        return minSum;
    }
}