//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int n, int balloons[])
    {
        int[][] coins = new int[n][n];        
        
        for(int i = n - 1; i >= 1; --i){
            for(int j = i + 1; j < n; ++j){
                int temp = Integer.MAX_VALUE;
                for(int k = i; k < j; ++k){
                    int pre = coins[i][k];
                    int post = coins[k + 1][j];
                    temp = Math.min(temp, 
                                  pre + post + 
                                  balloons[i - 1] * balloons[k] * balloons[j]);
                }
                
                coins[i][j] = temp;
            }
        }
        
        return coins[1][n - 1];
    }
}

// NIL NIL NIL  NIL   NIL
// NIL  0 24000 14000 26000
// NIL NIL  0   6000  12000
// NIL NIL NIL   0    9000
// NIL NIL NIL  NIL   0


// (1, 4) = min(1,1 : 2,4; 1,2 : 3,4; 1,3 : 4,4)
//        = min(0 + 12k + 20*30*30, 24k + 9k + 40*30*30, 14k + 0 + 40*10*30)
//        = min(30k, 59k, 26k)







