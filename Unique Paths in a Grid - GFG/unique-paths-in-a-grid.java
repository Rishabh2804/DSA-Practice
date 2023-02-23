//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int mod = 1000000007;
    
    static int uniquePaths(int n, int m, int[][] grid) {
        for(int i = 1; i < n; ++i){
            int j = 0;
            if(grid[i][j] == 0)
                continue;
            else
                grid[i][j] = grid[i - 1][j];
        }
        
        for(int j = 1; j < m; ++j){
            int i = 0;
            if(grid[i][j] == 0)
                continue;
            else
                grid[i][j] = grid[i][j - 1];
        }
        
        for(int i = 1; i < n; ++i){
            for(int j = 1; j < m; ++j){
                if(grid[i][j] == 0)
                    continue;
                else
                    grid[i][j] = add(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        
        return grid[n - 1][m - 1] % mod;
    }
    
    static int add(int a, int b){
        return (a + b) % mod;
    }
};