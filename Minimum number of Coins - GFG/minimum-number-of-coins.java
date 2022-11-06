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
            
            Solution ob = new Solution();
            List<Integer> numbers= new ArrayList<Integer>();
            numbers = ob.minPartition(N);
            for(int i: numbers){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    
    static int[] denominations = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
    
    static List<Integer> minPartition(int N)
    {
        List<Integer> list = new ArrayList<>();
        while(N > 0){
            int idx = lower_bound(N);
            int count = N / denominations[idx];
            while(count --> 0)
                list.add(denominations[idx]);
            
            N = N % denominations[idx];
        }
        
        return list;
    }
    
    static int lower_bound(int n){
        
        int si = 0, ei = denominations.length;
        while(si < ei) {
            int mid = (si + ei) / 2;
            if(denominations[mid] <= n)
                si = mid + 1;
            else 
                ei = mid;
        }
        
        return si - 1;
    }
    
    
}