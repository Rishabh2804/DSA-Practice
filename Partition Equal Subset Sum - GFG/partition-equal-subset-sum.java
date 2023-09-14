//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    
    static boolean solve(int i, int sum, int[] arr, Boolean[][] dp){
        if(sum == 0) return true;
        if(i >= arr.length) return false;
        
        if(dp[i][sum] != null) return dp[i][sum];
        
        boolean leave = solve(i + 1, sum, arr, dp);
        if(leave) return dp[i][sum] = true;
        
        boolean take = false;
        if(sum >= arr[i]) take = solve(i + 1, sum - arr[i], arr, dp);
        
        return dp[i][sum] = leave | take;
    }
    
    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        for(int i : arr) sum += i;
        
        if(sum % 2 != 0) return 0;
        
        sum >>= 1;
        return solve(0, sum, arr, new Boolean[N][1 + sum]) ? 1 : 0;
    }
}