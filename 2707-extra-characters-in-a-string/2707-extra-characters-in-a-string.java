class Solution {
    
    private int solve(int i, String s, String[] dictionary, Integer[] dp){
        if(i >= s.length()) return 0;
        
        if(dp[i] != null) return dp[i];
        
        int leave = 1 + solve(i + 1, s, dictionary, dp);
        
        int take = s.length();
        for(String word : dictionary){
            if(i + word.length() > s.length()) continue;
            
            if(s.substring(i, i + word.length()).equals(word))
                take = Math.min(take, solve(i + word.length(), s, dictionary, dp));            
        }
        
        return dp[i] = Math.min(leave, take);
    }
    
    public int minExtraChar(String s, String[] dictionary) {
        Integer[] dp = new Integer[s.length()];
        
        int ans = solve(0, s, dictionary, dp);
        for(var i : dp)
            System.out.print(i + " ");
        System.out.println();
        return ans;
    }
}