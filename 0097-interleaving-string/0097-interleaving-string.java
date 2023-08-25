class Solution {
    private boolean solve(int i, int j, int k, String s1, String s2, String s3, Boolean[][][] dp){
        if(k >= s3.length()) return i >= s1.length() && j >= s2.length();
        
        if(i >= s1.length()) return s2.substring(j).equals(s3.substring(k));
        if(j >= s2.length()) return s1.substring(i).equals(s3.substring(k));
        
        if(dp[i][j][k] != null) return dp[i][j][k];
        
        boolean ans = false;
        if(s1.charAt(i) == s3.charAt(k))
            ans = ans || solve(i + 1, j, k + 1, s1, s2, s3, dp);
        
        if(s2.charAt(j) == s3.charAt(k))
            ans = ans || solve(i, j + 1, k + 1, s1, s2, s3, dp);
        
        return dp[i][j][k] = ans; 
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][][] dp = new Boolean[s1.length()][s2.length()][s3.length()];
        return solve(0, 0, 0, s1, s2, s3, dp);
    }
}