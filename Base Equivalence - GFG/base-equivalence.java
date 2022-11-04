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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int m = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.baseEquiv(n,m));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    int pow(int n, int m) {
        return (int)Math.pow(n, m);
    }
    
    String baseEquiv(int n, int m) {
        return solve(n, m) ? "Yes" : "No";
    }
    
    boolean solve(int n, int m){
        
        int si = 2, ei = 32;
        while(si <= ei){
            int mid = (si + ei) / 2;
            int lb = (int)Math.pow(mid, m - 1);
            int ub = (int)Math.pow(mid, m) - 1;
            
            if(n >= lb && n <= ub)
                return true;
            else if(n < lb)
                ei = mid - 1;
            else
                si = mid + 1;
        }
        
        return false;
    }
}