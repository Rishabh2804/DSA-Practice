//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    
    private int getVal(char roman){
        int ans;
        switch(roman){
            case 'I' : ans = 1; break;
            case 'V' : ans = 5; break;
            case 'X' : ans = 10; break;
            case 'L' : ans = 50; break;
            case 'C' : ans = 100; break;
            case 'D' : ans = 500; break;
            case 'M' : ans = 1000; break;
            
            default : ans = 0;
        }
        
        return ans;
    }
    
    private int handleSecond(char first, char second){
        return getVal(first) - getVal(second);
    }
    
    private int solve(int i, String str){
        if(i >= str.length()) return 0;
        
        char first = str.charAt(i);
        char second = '.';
        if(i <= str.length() - 2)
            second = str.charAt(i + 1);
            
        switch(first){
            case 'I' : {
                if(second == 'V' || second == 'X')
                    return getVal(second) - getVal(first) + solve(i + 2, str);
                else 
                    return getVal(first) + solve(i + 1, str);
            }
            
            case 'X' : {
                if(second == 'L' || second == 'C')
                    return getVal(second) - getVal(first) + solve(i + 2, str);
                else 
                    return getVal(first) + solve(i + 1, str);
            }
            
            case 'C' : {
                if(second == 'D' || second == 'M')
                    return getVal(second) - getVal(first) + solve(i + 2, str);
                else 
                    return getVal(first) + solve(i + 1, str);
            }
            
            default : return getVal(first) + solve(i + 1, str);
        }
    }
    
    public int romanToDecimal(String str) {
        return solve(0, str);
    }
}