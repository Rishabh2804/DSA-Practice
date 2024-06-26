class Solution {
    
    private static final int START = 26;
    
    private int solve(int i, int prev, int k, String s, int[][] dp){
        if(i >= s.length()) return 0;
        
        if(dp[i][prev] != -1) return dp[i][prev];
                
        int leave = solve(i + 1, prev, k, s, dp);                
        int take = 0;
        
        int curr = s.charAt(i) - 'a';
        if(prev == START || Math.abs(curr - prev) <= k) 
            take = 1 + solve(i + 1, curr, k, s, dp);
        
        return dp[i][prev] = Math.max(leave, take);
    }
    
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n][27];
        
        for(int[] row : dp) 
            Arrays.fill(row, -1);
        
        return solve(0, START, k, s, dp);
    }
}