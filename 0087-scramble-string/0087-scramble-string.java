class Solution {
    public boolean isScramble(String s1, String s2) {
        int[][][] dp = new int[s1.length()][s2.length()][s2.length() + 1];
        for(int[][] mat : dp){
            for(int[] row : mat)
                Arrays.fill(row, -1);
        }
        
        return isScramble(0, 0, s1.length(), dp, s1, s2) == 1;
    }
    
    public int isScramble(int i, int j, int segLength, int[][][] dp, String s1, String s2) {
        
        if(dp[i][j][segLength] != -1)
            return dp[i][j][segLength];
        
        if(segLength == 0)
            return 1;
        
        if(segLength == 1)
            return dp[i][j][segLength] = (s1.charAt(i) == s2.charAt(j)) ? 1 : 0;
        
        int ans = 0;
        for(int splitLength = 1; splitLength < segLength; ++splitLength){
            int ans11 = isScramble(i, j, splitLength, dp, s1, s2);
            int ans12 = isScramble(i + splitLength, j + splitLength, segLength - splitLength, dp, s1, s2);
            
            ans = (ans11 * ans12);
            if(ans == 1)
                break;
            
            int ans21 = isScramble(i, j + segLength - splitLength, splitLength, dp, s1, s2);
            int ans22 = isScramble(i + splitLength, j, segLength - splitLength, dp, s1, s2);
            
            ans = (ans21 * ans22);
            if(ans == 1)
                break;
        }
        
        return dp[i][j][segLength] = ans;            
    }
}