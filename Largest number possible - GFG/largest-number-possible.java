//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String findLargest(int N, int S){
        if(S > 9 * N) return "-1";
        
        if(S == 0){
            if(N == 1) return "0";
            else return "-1";
        }
        
        StringBuilder ans = new StringBuilder();
        while(ans.length() < N){
            int dig = 0;
            if(S > 9) dig = 9;
            else dig = S;
            
            S -= dig;
            
            ans.append((char)('0' + dig));
        }
        
        return ans.toString();
    }
}