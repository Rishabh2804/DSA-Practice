//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    public static int longestPalindromicString(String str) 
    {
        // Create temporary String
        StringBuilder temp = new StringBuilder(str);
        
        StringBuilder sb = new StringBuilder(str);
        sb.append('|');
        
        // Reverse the String str
        sb.append(temp.reverse().toString());
     
        // Find the length of String temp
        int n = sb.length();
     
        // lps[] array for String temp
        int []lps = new int[n];
     
        // Initialise every value with zero
        Arrays.fill(lps, 0);
     
        // Iterate the String temp
        for(int i = 1; i < n; i++)
        {
             
           // Length of longest prefix
           // till less than i
           int len = lps[i - 1];
            
           // Calculate length for i+1
           while (len > 0 && sb.charAt(len) !=
                             sb.charAt(i))
           {
               len = lps[len - 1];
           }
            
           // If character at current index
           // len are same then increment
           // length by 1
           if (sb.charAt(i) == sb.charAt(len))
           {
               len++;
           }
            
           // Update the length at current
           // index to len
           lps[i] = len;
        }
        
        return lps[n - 1];
    }
    
	public static int addMinChar(String str){
		return str.length() - longestPalindromicString(str);
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String str = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.addMinChar(str));
        }
        
    }
}

// } Driver Code Ends