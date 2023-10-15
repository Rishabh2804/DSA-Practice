class Solution {
    
    private static final int MAX_STEPS = 500;
    /**
    *   Steps count : 
    *      arr[i] --> arr[i + 1] == 1
    *      arr[i] <-- arr[i + 1] == 1
    *   
    *   => Thus, a complete round-about path 
    *         arr[i] -->  arr[j] 
    *      takes 2 * (j - i) steps
    *   
    *   => For threshold limit of [MAX_STEPS] steps, 
    *      furthest point reachable from index i is => i + MAX_STEPS / 2
    *   => From start point 0, furthest point reachable would be 
    *           (0 + MAX_STEPS) ==> MAX_STEPS / 2
    *   => Maximum feasible length of array = (ei - si + 1) ==> MAX_STEPS / 2 + 1
    *   => MAX_EFFECTIVE_SIZE = 1 + MAX_STEPS / 2
    **/
    private static final int MAX_EFFECTIVE_SIZE = 1 + MAX_STEPS / 2;
    
    static final int MOD = 1000000007;
    
    private static final int ADD(int num1, int num2){
        return ((num1 % MOD) + (num2 % MOD)) % MOD;
    }
    
    private int solve(int i, int steps, int n, Integer[][] dp){
        if(i < 0 || i >= n) return 0;
        
        if(steps <= 0) return (i == 0) ? 1 : 0;
        
        if(dp[i][steps] != null) return dp[i][steps];
        
        int stay = solve(i, steps - 1, n, dp);
        int left = solve(i - 1, steps - 1, n, dp);
        int right = solve(i + 1, steps - 1, n, dp);
        
        return dp[i][steps] = ADD(stay, ADD(left, right));
    }
    
    public int numWays(int steps, int arrLen) {
        int n = Math.min(arrLen, MAX_EFFECTIVE_SIZE);
        return solve(0, steps, n, new Integer[n][steps + 1]);
    }
}