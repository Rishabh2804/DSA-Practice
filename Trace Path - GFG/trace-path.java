//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String srgs[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s1[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPossible(n, m, s));
        }
    }
}
// } Driver Code Ends


// User function Template for 

class Solution{
    static int isPossible(int n, int m, String s){
        int horizon = 0;
        int vertical = 0;
        
        int minX = 0, maxX = 0;
        int minY = 0, maxY = 0;
        
        for(int i = 0; i < s.length(); ++i){
            switch(s.charAt(i)){
                case 'L' : horizon--;
                           break;
                case 'R' : horizon++;
                           break;
                case 'U' : vertical++;
                           break;
                case 'D' : vertical--;
                           break;
            }
            
            minX = Math.min(minX, horizon);
            minY = Math.min(minY, vertical);
            maxX = Math.max(maxX, horizon);
            maxY = Math.max(maxY, vertical);
          
        }
        
        int xLen = maxX - minX + 1;
        int yLen = maxY - minY + 1;
        
        if(xLen > m) return 0;
        else if(yLen > n) return 0;
        else return 1; 
    }
}