//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            String arr = read.readLine().trim();

            Solution ob = new Solution();
            out.println(ob.appleSequence(N, M, arr));
        }
        out.close();
    }
}


// } Driver Code Ends
//User function Template for Java


class Solution{
    public static int appleSequence(int n, int m, String arr){
        
        List<Integer> indices = new ArrayList<>();
        indices.add(-1);
        for(int i = 0; i < arr.length(); ++i){
            if(arr.charAt(i) == 'O')
                indices.add(i);
        }
        indices.add(n);
        
        if(m >= indices.size() - 2)
            return n;
        
        int maxLen = 0;
        for(int i = m; i < indices.size() - 1; ++i){
            int leftLen = indices.get(i) - indices.get(i - m) - 1;
            int rightLen = indices.get(i + 1) - indices.get(i) - 1;
            
            int totalLen = leftLen + rightLen + 1;
            maxLen = Math.max(maxLen, totalLen);
        }
        
        return maxLen;
    }
}


//{ Driver Code Starts.

// } Driver Code Ends