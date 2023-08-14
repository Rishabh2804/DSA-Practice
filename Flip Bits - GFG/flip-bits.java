//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maxOnes(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public static int Kadane(int[] arr){
        
        int n = arr.length;
        int minSum = n;
        
        int sum = 0;
        for(int i = 0; i < n; ++i){
            sum += arr[i];
            if(sum > 0)
                sum = 0;
                
            minSum = Math.min(minSum, sum);
        }
        
        return minSum;
    }
    
    public static int maxOnes(int a[], int n) {
        
        int ones = 0;
        // convert 0 to -1
        for(int i = 0; i < n; ++i) {
            ones += a[i];
            a[i] = 2 * a[i] - 1;
        }
        
        // using Kadane's algo to find smallest subarray sum
        int flips = Kadane(a);
        
        return ones - flips; // or ones + (-flips)
    }
}
