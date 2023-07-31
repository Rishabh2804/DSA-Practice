class Solution {
    
    private int solve(int i, int j, String s1, String s2, int[][] dp){
        if(i >= s1.length() || j >= s2.length())
            return 0;
        
        if(dp[i][j] != 0) return dp[i][j];
        
        if(s1.charAt(i) == s2.charAt(j)){
            int ascii = s1.charAt(i) - '\0';
            return dp[i][j] += 2 * ascii + solve(i + 1, j + 1, s1, s2, dp);
        } 
        
        int op1 = solve(i + 1, j, s1, s2, dp);
        int op2 = solve(i, j + 1, s1, s2, dp);
        
        return dp[i][j] = Math.max(op1, op2);
    }
    
    public int minimumDeleteSum(String s1, String s2) {
        
        int totalAsciiSum = 0;
        for(int i = 0; i < s1.length(); ++i){
            int ascii = s1.charAt(i) - '\0';
            totalAsciiSum += ascii;
        }
        
        for(int i = 0; i < s2.length(); ++i){
            int ascii = s2.charAt(i) - '\0';
            totalAsciiSum += ascii;
        }
        
        int[][] dp = new int[s1.length()][s2.length()];
        
        int equalSum = solve(0, 0, s1, s2, dp);
        return totalAsciiSum - equalSum;
    }
}