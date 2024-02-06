class Solution {
    
    private int solve(int i, int j, String s, String t, int[][] dp){
        if(j >= t.length()) return 1;
        if(i >= s.length()) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int leave = solve(i + 1, j, s, t, dp);
        
        int take = 0;
        if(s.charAt(i) == t.charAt(j))
            take = solve(i + 1, j + 1, s, t, dp);            
        
        return dp[i][j] = leave + take;
    }
    
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        int[][] dp = new int[n][m];
        
        for(int[] row : dp) Arrays.fill(row, -1);
        
        return solve(0, 0, s, t, dp);
    }
}