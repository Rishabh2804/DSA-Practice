//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [][] costs = new int[n][k];
			for(int i = 0; i < n; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < k; j++) {
					costs[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.minCost(costs));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minCost(int [][] costs) {
		int n = costs.length;
		if(n == 0)
		    return 0;
		    
		int k = costs[0].length;
		if(k == 0)
		    return -1;
		
		int lowest = Integer.MAX_VALUE;
		int lowest2 = Integer.MAX_VALUE;
		
		for(int i = 0; i < k; ++i){
		    if(costs[0][i] <= lowest){
		        lowest2 = lowest;
		        lowest = costs[0][i];
		    } else if(costs[0][i] <= lowest2)
		        lowest2 = costs[0][i];
		}
		
		if(k == 1){
		    if(n == 1) return lowest;
		     else return -1;
		}
		
		for(int i = 1; i < n; ++i){
		    int l1 = Integer.MAX_VALUE;
		    int l2 = Integer.MAX_VALUE;
		    
		    for(int j = 0; j < k; ++j){
		        if(costs[i - 1][j] == lowest)
		            costs[i][j] += lowest2;
		        else
		            costs[i][j] += lowest;
		            
		        if(costs[i][j] <= l1){
		            l2 = l1;
		            l1 = costs[i][j];
		        } else if(costs[i][j] <= l2)
		            l2 = costs[i][j];
		    }
		    
		    lowest = l1;
		    lowest2 = l2;
		}
		
		return lowest;
	}
}