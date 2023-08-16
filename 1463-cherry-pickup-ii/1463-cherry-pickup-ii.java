class Solution {
    
    static final int ROW = 0;
    static final int ROBO1 = 1;
    static final int ROBO2 = 2;
    
    static final int[] nextDir = {-1, 0, 1};
    
    private int solve(int i, int j1, int j2, int[][] grid, Integer[][][] dp){
        if(i >= dp.length) return 0;
        
        if(j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length)
            return 0;        

        if(dp[i][j1][j2] != null) return dp[i][j1][j2];
        
        int cherry1 = grid[i][j1];        
        int cherry2 = grid[i][j2];
        
        if(j1 == j2) cherry2 = 0;
        
        dp[i][j1][j2] = 0;
        for(int x1 = -1; x1 <= 1; ++x1){
            for(int x2 = -1; x2 <= 1; ++x2){
                int cherries = solve(i + 1, j1 + x1, j2 + x2, grid, dp);
                dp[i][j1][j2] = Math.max(dp[i][j1][j2], cherries);
            }
        }
        
        return dp[i][j1][j2] += cherry1 + cherry2;
    }
    
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Integer[][][] dp = new Integer[n][m][m];
        return solve(0, 0, m - 1, grid, dp);
    }
}