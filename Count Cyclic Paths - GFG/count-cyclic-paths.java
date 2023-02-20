//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    static int mod = 1000000007;
    
	public static int countPaths(int N){
		if(N <= 1)
		    return 0;
		  
		int[][] paths = new int[4][N + 1];
		paths[1][1] = 1;
		paths[2][1] = 1;
		paths[3][1] = 1;
		
		for(int i = 2; i <= N; ++i){
		    paths[0][i] = ADD(ADD(paths[1][i - 1], paths[2][i - 1]), paths[3][i - 1]);
		    paths[1][i] = ADD(ADD(paths[0][i - 1], paths[2][i - 1]), paths[3][i - 1]);
		    paths[2][i] = ADD(ADD(paths[0][i - 1], paths[1][i - 1]), paths[3][i - 1]);
		    paths[3][i] = ADD(ADD(paths[0][i - 1], paths[1][i - 1]), paths[2][i - 1]);
		}
		
		return paths[0][N] % mod;
	}
	
	public static int ADD(int a, int b){
	    return (a + b) % mod;
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countPaths(N));
        }
    }
}

// } Driver Code Ends