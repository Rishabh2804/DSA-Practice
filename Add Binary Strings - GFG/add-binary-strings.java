//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            String b = input[1];
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String addBinary(String A, String B) {
        int carry = 0;
        
        StringBuilder sb = new StringBuilder();
        
        int i = A.length() - 1;
        int j = B.length() - 1;
        int last = 0;
        
        while(i >= 0 && j >= 0){
            int a = A.charAt(i) - '0';
            int b = B.charAt(j) - '0';
            
            int sum = a + b + carry;
            
            carry = sum / 2;
            sum %= 2;
            
            sb.append(sum);
            
            if(sum == 1)
                last = sb.length();
            
            i--;
            j--;
        }
        
        while(i >= 0){
            int a = A.charAt(i) - '0';
            
            int sum = a + carry;
            
            carry = sum / 2;
            sum %= 2;
            
            sb.append(sum);
            
            if(sum == 1)
                last = sb.length();
            
            i--;
        }
        
        while(j >= 0){
            int b = B.charAt(j) - '0';
            
            int sum = b + carry;
            
            carry = sum / 2;
            sum %= 2;
            
            sb.append(sum);
            
            if(sum == 1)
                last = sb.length();
            
            j--;
        }
        
        if(carry == 1){
            sb.append(1);
            last = sb.length();
        }
        
        int start = sb.length() - last;
        
        return sb.reverse().substring(start);
    }
}