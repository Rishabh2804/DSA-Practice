//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[][] matrix = IntMatrix.input(br, N, N);
            
            Solution obj = new Solution();
            int res = obj.findMinOperation(N, matrix);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findMinOperation(int n, int[][] matrix) {
        int maxSum = 0;
        
        int[] rowSum = new int[n];
        int[] colSum = new int[n];
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                rowSum[i] += matrix[i][j];
                colSum[j] += matrix[i][j];
            }
            
            maxSum = Math.max(maxSum, rowSum[i]);
            if(i == n - 1){
                for(int j = 0; j < n; ++j)
                    maxSum = Math.max(maxSum, colSum[j]);
            }
        }
        
        // System.out.println(maxSum);
        
        for(int i = 0; i < n; ++i){
            rowSum[i] -= maxSum;
            colSum[i] -= maxSum;
        }
        
        int updatesCount = 0;
        for(int i = 0; i < n; ++i){
            if (rowSum[i] == 0) continue;
            
            for(int j = 0; j < n; ++j){
                if (colSum[j] == 0) continue;
                
                int update = Math.max(rowSum[i], colSum[j]);
                rowSum[i] -= update;
                colSum[j] -= update;
                updatesCount -= update;
                
                if(rowSum[i] == 0) break;
            }
        }
        
        return updatesCount;
    }
}
        
