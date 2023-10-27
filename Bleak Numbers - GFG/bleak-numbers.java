//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.is_bleak(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    private int countBits(int n){
        int count = 0;
        while(n != 0){
            count += n & 1;
            n >>= 1;
        }
        
        return count;
    }
    
    public int is_bleak(int n)
    {
        int lim = Math.min(n, 32);
        for(int i = 1; i <= lim; ++i){
            if(countBits(n - i) == i) return 0;
        }
        
        return 1;
    }
}