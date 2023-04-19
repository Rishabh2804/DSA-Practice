//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.numberWithNoConsecutiveOnes(n);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[]  numberWithNoConsecutiveOnes(int n)
    {
        ArrayList<Integer> ans = solve(n);
        int[] res = new int[ans.size() - 1];
        for(int i = 0; i < ans.size() - 1; ++i)
            res[i] = ans.get(i + 1);
            
        return res;
    }
    
    public ArrayList<Integer> solve(int n){
        ArrayList<Integer> ans = new ArrayList<>();
        if(n == 1){
            ans.add(0);
            ans.add(1);
            return ans;
        }
        
        ArrayList<Integer> pre = solve(n - 1);
        for(int num : pre){
            if(num % 2 == 0){
                ans.add(2 * num);
                ans.add(2 * num + 1);
            } else
                ans.add(2 * num);
        }
        
        return ans;
    }
}