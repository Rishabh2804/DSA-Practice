//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        
        int distinct = 0;
        int[] freq = new int[26];
        int maxLen = -1;
        
        int si = 0, ei = 0;
        while(ei < s.length()){
            int idx = s.charAt(ei) - 'a';
            freq[idx]++;
            
            if(freq[idx] == 1) // new character
                distinct++;
            
            while(si <= ei && distinct > k){
                int idx2 = s.charAt(si) - 'a';
                freq[idx2] --;
                    
                if(freq[idx2] == 0)
                    distinct--;
                    
                si++;
            }
            
            if(distinct == k)
                maxLen = Math.max(maxLen, ei - si + 1);
            
            ei++;
        }
        
        return maxLen;
    }
}