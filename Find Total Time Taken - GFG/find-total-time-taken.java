//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            int n=Integer.parseInt(in.readLine().trim());
            int a[]=new int[n];
            String s[]=in.readLine().trim().split(" ");
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            s=in.readLine().trim().split(" ");
            int time[]=new int[n];
            for(int i=0;i<n;i++){
                time[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long ans=ob.totalTime(n,a,time);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long totalTime(int n, int arr[], int time[]) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        // for (int i = 0; i <= max ; i++) {
        
        // }

        int hash[] = new int[max + 1];// 9
        hash[arr[0]] = 1;
        
        long total = 0;
        for (int i = 1; i < n; i++) {
            if (hash[arr[i]] > 0) {
                total += time[arr[i] - 1];
                // hash[arr[i]]--;
            } else {
                total += 1;
            }
            
            hash[arr[i]]++;
        }
        
        return total;
    }
}