class Solution {
    
    private boolean solveDP(int i, String s, int open, Boolean[][] dp){
        if(i >= s.length()) return open == 0;
        if(open < 0) return false;
        
        if(dp[i][open] != null) return dp[i][open];
        
        if(s.charAt(i) == '(') return dp[i][open] = solveDP(i + 1, s, open + 1, dp);
        else if(s.charAt(i) == ')') {
            if(open <= 0) return dp[i][open] = false;
            return dp[i][open] = solveDP(i + 1, s, open - 1, dp);
        } else {
            boolean op = solveDP(i + 1, s, open + 1, dp);
            boolean cl = solveDP(i + 1, s, open - 1, dp);
            boolean blank = solveDP(i + 1, s, open, dp);
            
            return dp[i][open] = op || cl || blank;
        }
    }
    
    public boolean checkValidString(String s) {
        
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n + 1];
        return solveDP(0, s, 0, dp);
        
//         int countOpen = 0;
//         int countStar = 0;
        
//         Stack<Character> st = new Stack<>();
        
//         for(int i = 0; i < s.length(); ++i){
//             if(s.charAt(i) == '(') countOpen++;
//             else if(s.charAt(i) == '*') countStar ++;
//             else {
//                 if(countOpen > 0) countOpen --;
//                 else if (countStar > 0) countStar --;
//                 else return false;
//             }
//         }
        
//         return countStar >= countOpen;
    }
}