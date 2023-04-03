//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
  
            String x = br.readLine(); 
            
            Solution ob = new Solution();
		
            System.out.println(ob.xmod11(x)); 

            t--;
        }
    } 
} 



// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int xmod11(String x)
	{   
	    int oddSum = 0;
	    int eveSum = 0;
	    
	    boolean flag = (x.length() % 2 == 0);
	    for(int i = 0; i < x.length(); ++i){
	        if(flag)
	            eveSum += x.charAt(i) - '0';
	        else
	            oddSum += x.charAt(i) - '0';
	            
	        flag = flag == false;
	    }
	    
	    int ans = (oddSum - eveSum) % 11;
	    return (ans + 11) % 11;
	}
	
	
} 

