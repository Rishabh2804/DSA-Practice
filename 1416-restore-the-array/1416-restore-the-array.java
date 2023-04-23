class Solution {
    static final int mod = 1000000007;
    
    public int solve(int si, String s, int k, int[] dp){          
        if(si == s.length())
            return 1;

        if(s.charAt(si) == '0')
            return 0; // no leading zeroes or empty array allowed
        
        if(dp[si] != -1)
            return dp[si];
        
        int ans = 0;
        long currVal = 0;
        int i = si;
        while(i < s.length()){
            currVal = currVal * 10 + (s.charAt(i) - '0');
            if(currVal > k)
                break;
            
            ans = ((ans % mod) + (solve(i + 1, s, k, dp) % mod)) % mod;
            i++;
        }
        
        return dp[si] = ans % mod;
    }
    
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return solve(0, s, k, dp);
    }
}