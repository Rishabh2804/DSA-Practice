class Solution {
    
    static final char ANY = '?';
    static final char ALL = '*';
    
    // Recursive
    // TC --> O(2^(min(|s|, |p|)))
    // SC --> O(2^(min(|s|, |p|))) (stack space)    
    private boolean match(int i, int j, String s, String p){
        if(j >= p.length()) return i >= s.length();
        
        if(i >= s.length()) return p.charAt(j) == ALL && match(i, j + 1, s, p);
        
        if(p.charAt(j) == ANY) return match(i + 1, j + 1, s, p);
        if(p.charAt(j) == ALL) 
            return match(i, j + 1, s, p) || match(i + 1, j, s, p);
        
        return p.charAt(j) == s.charAt(i) && match(i + 1, j + 1, s, p);        
    }
    
    // Memoized
    // TC --> O(|s| * |p|)
    // SC --> O(|s| * |p|)
    private boolean matchMemo(int i, int j, String s, String p, Boolean[][] dp){
        if(j >= p.length()) return i >= s.length();
        
        if(i >= s.length()) return p.charAt(j) == ALL && matchMemo(i, j + 1, s, p, dp);
        
        if(dp[i][j] != null) return dp[i][j];
        
        if(p.charAt(j) == ANY) return dp[i][j] = matchMemo(i + 1, j + 1, s, p, dp);
        if(p.charAt(j) == ALL) 
            return dp[i][j] = matchMemo(i, j + 1, s, p, dp) || matchMemo(i + 1, j, s, p, dp);
        
        return dp[i][j] = p.charAt(j) == s.charAt(i) && matchMemo(i + 1, j + 1, s, p, dp);        
    }
    
    public boolean isMatch(String s, String p) {                
        // return match(0, 0, s, p);    
        return matchMemo(0, 0, s, p, new Boolean[s.length()][p.length()]);
    }
}