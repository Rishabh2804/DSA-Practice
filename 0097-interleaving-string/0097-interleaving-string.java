class Solution {
    private int solve(int i, int j, int k, String s1, String s2, String s3, Integer[][] dp){
        if(k >= s3.length()) return 0;
        
        if(i >= s1.length()){
            if(s2.substring(j).equals(s3.substring(k)))
                return s3.length() - k;
            else return 0;
        }
        
        if(j >= s2.length()){
            if(s1.substring(i).equals(s3.substring(k)))
                return s3.length() - k;
            else return 0;
        }
        
        if(dp[i][j] != null) return dp[i][j];
        
        int op1 = 0;
        if(s1.charAt(i) == s3.charAt(k))
            op1 = 1 + solve(i + 1, j, k + 1, s1, s2, s3, dp);
        
        int op2 = 0;
        if(s2.charAt(j) == s3.charAt(k))
            op2 = 1 + solve(i, j + 1, k + 1, s1, s2, s3, dp);
        
        return dp[i][j] = Math.max(op1, op2); 
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;
        
        Integer[][] dp = new Integer[s1.length()][s2.length()];
        int match = solve(0, 0, 0, s1, s2, s3, dp);
        
        return match == s3.length();
    }
}