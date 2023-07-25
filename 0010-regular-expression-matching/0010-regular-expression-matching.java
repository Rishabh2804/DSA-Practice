class Solution {
    static final char ANY_CHAR = '.';
    static final char ANY_FREQ = '*';
    
    boolean isStarState(int pi, String p){
        return pi + 1 < p.length() && p.charAt(pi + 1) == ANY_FREQ;
    }
    
    boolean isMatch(int si, int pi, String s, String p){
        // check for match (identical character or dot state)
        return p.charAt(pi) == ANY_CHAR || (si < s.length() && p.charAt(pi) == s.charAt(si));
    }
    
    Boolean solve(int si, int pi, String s, String p, Boolean[][] dp){
        if(pi >= p.length()) return si >= s.length();
        
        if(dp[si][pi] != null) return dp[si][pi];
        
        if(si >= s.length()){
            if(isStarState(pi, p)) return dp[si][pi] = solve(si, pi + 2, s, p, dp);
            else return dp[si][pi] = false;
        }
        
        // check for star state
        if(isStarState(pi, p)) {
            // option to skip current pattern state
            boolean skip = solve(si, pi + 2, s, p, dp);  
            if(skip == true) return dp[si][pi] = true;
            
            // check for match
            if(isMatch(si, pi, s, p)) {
                boolean repeat = solve(si + 1, pi, s, p, dp);                
                if(repeat == true) return dp[si][pi] = true;
                else {
                    boolean next = solve(si + 1, pi + 2, s, p, dp);                
                    if(next == true) return dp[si][pi] = true;
                }
            } else return dp[si][pi] = skip; // would be false anyways                        
        }
        
        if(isMatch(si, pi, s, p)) 
            return dp[si][pi] = solve(si + 1, pi + 1, s, p, dp);
        
        return dp[si][pi] = false;
    }
    
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        
        return solve(0, 0, s, p, dp);
    }
}