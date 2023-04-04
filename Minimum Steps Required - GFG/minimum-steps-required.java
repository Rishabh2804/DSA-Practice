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
			String str = br.readLine();
			Solution obj = new Solution();
			System.out.println(obj.minSteps(str));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minSteps(String str) {
	    int count = 1;
	    char prev = str.charAt(0);
	    for(int i = 0; i < str.length(); ++i){
	        if(str.charAt(i) == prev)
	            continue;
	        else {
	            count ++;
	            prev = str.charAt(i);
	        }
	    }
	   
		return (count + 2) / 2;
	}
}