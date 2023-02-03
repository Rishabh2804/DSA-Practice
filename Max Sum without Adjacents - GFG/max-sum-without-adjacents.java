//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        if(n == 1)
            return arr[0];
        else if(n == 2)
            return Math.max(arr[0], arr[1]);
        else if(n == 3)
            return Math.max(arr[0] + arr[2], arr[1]);
            
        int[] sums = new int[n];
        sums[0] = arr[0];
        sums[1] = arr[1];
        sums[2] = arr[0] + arr[2];
        for(int i = 3; i < n; ++i)
            sums[i] = arr[i] + Math.max(sums[i - 2], sums[i - 3]);
        
        return Math.max(sums[n - 1], sums[n - 2]);
    }
}