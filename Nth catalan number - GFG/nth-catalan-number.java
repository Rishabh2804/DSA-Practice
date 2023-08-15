//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.findCatalan(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    static final int MOD = 1000000007;
    
    public static int findCatalan(int n) {
        
        int[] catalan = new int[n + 1];
        catalan[0] = 1;
        catalan[1] = 1;
        
        for(int i = 2; i <= n; ++i){
            for(int j = 0; j < i / 2; ++j){
                catalan[i] += (int) ((2L * catalan[j] * catalan[i - j - 1]) % MOD);
                catalan[i] %= MOD;
            }
            
            if(i % 2 == 1){
                catalan[i] += (int) ((1L * catalan[i / 2] * catalan[i / 2]) % MOD);
                catalan[i] %= MOD;
            }
        }
        
        return catalan[n] % MOD;
    }
}
        
