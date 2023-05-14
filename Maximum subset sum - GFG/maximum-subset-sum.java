//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
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
            
            
            int[] A = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.findMaxSubsetSum(N, A);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    static final int CHOSEN = 0;
    static final int LEFT = 1;
    
    public static long findMaxSubsetSum(int N, int[] A) {
        long[][] sum = new long[N][2];
        
        sum[0][CHOSEN] = A[0];
        sum[0][LEFT] = 0;
        
        for(int i = 1; i < N; ++i){
            sum[i][CHOSEN] = A[i] + Math.max(sum[i - 1][CHOSEN], sum[i - 1][LEFT]);
            sum[i][LEFT] = sum[i - 1][CHOSEN];
        }
        
        return Math.max(sum[N - 1][CHOSEN], sum[N - 1][LEFT]);
    }
}
        
