//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            int res = obj.minimumSum(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minimumSum(String s) {
        char[] arr = s.toCharArray();
        for(int i = 0; i < s.length() / 2; ++i){
            if(arr[i] == '?')
                arr[i] = arr[arr.length - i - 1];
            
            if(arr[arr.length - i - 1] == '?')
                arr[arr.length - i - 1] = arr[i];
                
            if(arr[i] != arr[arr.length - i - 1])
                return -1;
        }
        
        int sum = 0;
        char last = '?';
        for(char c : arr){
            if(c == '?') continue;
            if(last != '?') 
                sum += Math.abs(c - last);
                
            last = c;
        }
        
        return sum;
    }
}
