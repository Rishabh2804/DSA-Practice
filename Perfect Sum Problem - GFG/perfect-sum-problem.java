//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{

    static final int MOD = 1000000007;
    
    public int solve(int i, int sum, List<Integer> arr, Integer[][] ways){
        if(i >= arr.size()) {
            if(sum == 0) return 1;
            else return 0;
        }
        
        if(ways[i][sum] != null) return ways[i][sum];
        
        int leave = solve(i + 1, sum, arr, ways);
        
        int take = 0;
        if(arr.get(i) <= sum) take = solve(i + 1, sum - arr.get(i), arr, ways);
        
        return ways[i][sum] = (leave + take) % MOD;
    }
    
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	   // Arrays.sort(arr);
	    
	   List<Integer> list = new ArrayList<>();
	   for(int i : arr)
	       list.add(i);
	   
	   Integer[][] ways = new Integer[n][sum + 1];
	   // for(int i = 0; i < n; ++i)
	   //     ways[i][0] = 1;
	    
	   // for(int j = 1; j <= sum; ++j)
	   //     ways[0][j] = (arr[0] == j) ? 1 : 0;
	       
	   // for(int i = 1; i < n; ++i){
	   //     for(int j = 1; j <= sum; ++j){
	   //         int leave = 0;
	   //         leave = ways[i - 1][j];
	            
	   //         int take = 0;
	   //         if(arr[i] <= j) take = ways[i - 1][j - arr[i]];
	            
	   //         ways[i][j] = (leave + take) % MOD;
	   //     }
	   // }
	    
	   // return ways[n - 1][sum] % MOD;
	   
	   return solve(0, sum, list, ways);
	} 
}