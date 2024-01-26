class Solution {
    
    static final int MOD = 1000000007;
    static final int MAX = 101;
    
    private static final int[] xDir = {-1, 0, 0, 1};
    private static final int[] yDir = {0, -1, 1, 0};
    
    private int ADD(int a, int b){
        return (a + b) % MOD;
    }
    
    private Integer solve(int m, int n, int moves, int i, int j, Integer[][][] dp) {
        if(i < 0 || i >= m || j < 0 || j >= n)
            return 1;
        
        if(moves <= 0) return 0;
        
        if(dp[i][j][moves] != null) return dp[i][j][moves];
        
        int count = 0;
        for(int dir = 0; dir < 4; ++dir){
            int x = i + xDir[dir];
            int y = j + yDir[dir];
            
            count = ADD(count, solve(m, n, moves - 1, x, y, dp));
        }
        
        return dp[i][j][moves] = count;        
    }
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n)
            return 1;
        
        if(maxMove <= 0) return 0;
        
        return solve(m, n, maxMove, startRow, startColumn, new Integer[m][n][maxMove + 1]);
    }
}