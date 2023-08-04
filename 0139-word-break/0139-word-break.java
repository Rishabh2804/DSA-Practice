class Solution {
        
    private boolean match(String str1, int si, String str2){
        if(str2.length() - si < str1.length()) return false;
        
        return str1.equals(str2.substring(si, si + str1.length()));
    }
    
    private boolean solve(int i, String s, List<String> wordDict, Boolean[] dp){
        if(i >= s.length()) return true;
        
        if(dp[i] != null) return dp[i];
        
        boolean ans = false;
        for(String word : wordDict){
            if(match(word, i, s)) {
                ans = solve(i + word.length(), s, wordDict, dp);
                if(ans) break;
            }
        }
        
        return dp[i] = ans;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(0, s, wordDict, new Boolean[s.length()]);
    }
}