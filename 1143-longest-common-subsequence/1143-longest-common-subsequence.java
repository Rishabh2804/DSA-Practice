class Solution {
    
    char[] text1;
    char[] text2;
    
    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1.toCharArray();
        this.text2 = text2.toCharArray();
        
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return solve(0, 0, dp);
    }
    
    public int solve(int i1, int i2, int[][] dp){
        if(i1 >= text1.length || i2 >= text2.length)
            return 0;
        
        if(dp[i1][i2] != -1)
            return dp[i1][i2];
            
        int op1 = solve(i1 + 1, i2 + 1, dp);
        if(text1[i1] == text2[i2])
            op1 ++;
        
        int op2 = solve(i1 + 1, i2, dp);
        int op3 = solve(i1, i2 + 1, dp);
        
        return dp[i1][i2] = Math.max(op1, Math.max(op2, op3));
    }
}