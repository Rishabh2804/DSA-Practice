class Solution {
    
    private boolean isValid(int n){
        return 1 <= n && n <= 26;
    }
    
    private int parse(String s){
        if(s.length() == 1) return s.charAt(0) - '0';
        else return 10 * (s.charAt(0) - '0') + (s.charAt(1) - '0');
    }
    
    private int solve(int i, String s, int[] dp){
        if(i >= s.length()) return 1;
        
        if(dp[i] != -1) return dp[i];
        
        int n = s.charAt(i) - '0';
        if(!isValid(n)) return dp[i] = 0;
        
        dp[i] = solve(i + 1, s, dp);
        if((n == 1 || n == 2) && i < s.length() - 1){
            n = 10 * n + (s.charAt(i + 1) - '0');
            if(isValid(n)) dp[i] += solve(i + 2, s, dp);
        }
        
        return dp[i];
    }
    
    public int numDecodings(String s) {
        int n = s.length();
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return solve(0, s, dp);
    }
}