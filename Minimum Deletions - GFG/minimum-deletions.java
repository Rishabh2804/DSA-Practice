//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static final int NONE = 10000;
    
    static int solve(int si, int ei, String s, Integer[][] dp){
        if(si >= ei) return 0;
        
        if(dp[si][ei] != null) return dp[si][ei];
        
        int leave = 1 + Math.min(solve(si + 1, ei, s, dp), solve(si, ei - 1, s, dp));
        int take = NONE;
        if(s.charAt(si) == s.charAt(ei))
            take = solve(si + 1, ei - 1, s, dp);
            
        return dp[si][ei] = Math.min(leave, take);
    }
    
    static int minimumNumberOfDeletions(String S) {
        int n = S.length();
        Integer[][] dp = new Integer[n][n];
        return solve(0, n - 1, S, dp);
    }
}