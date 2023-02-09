//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.maxInstance(s);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxInstance(String s) {
        int[] freq = new int[5];
        for(int i = 0; i < s.length(); ++i){
            switch(s.charAt(i)){
                case 'b' : freq[0]++; 
                           break;
                case 'a' : freq[1]++; 
                           break;
                case 'l' : freq[2]++; 
                           break;
                case 'o' : freq[3]++; 
                           break;
                case 'n' : freq[4]++; 
                default  : break;
            }
        }
        
        int instances = Math.min(freq[0], freq[1]);
        instances = Math.min(instances, freq[2] / 2);
        instances = Math.min(instances, freq[3] / 2);
        instances = Math.min(instances, freq[4]);
        
        return instances;
    }
}