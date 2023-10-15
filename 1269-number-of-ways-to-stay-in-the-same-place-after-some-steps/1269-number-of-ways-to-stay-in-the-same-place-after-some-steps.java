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
    
    /** Approach 1 : Recursive (of course TLE \U0001f605)
    *   Time Complexity --> O(3 ^ steps) 
    *   Space Complexity --> O(3 ^ steps) (Stack space)
    **/
    private int solve1(int i, int steps, int n){
        if(i < 0 || i >= n) return 0;
        
        if(steps <= 0) return (i == 0) ? 1 : 0;
        
        int stay = solve1(i, steps - 1, n);
        int left = solve1(i - 1, steps - 1, n);
        int right = solve1(i + 1, steps - 1, n);
        
        return ADD(stay, ADD(left, right));
    }
    
    /** Approach 2 : Memoization
    *   Time Complexity --> O(n * steps) 
    *   Space Complexity --> O(n * steps) + O(steps) (Stack space)
    **/
    private int solve2(int i, int steps, int n, Integer[][] dp){
        if(i < 0 || i >= n) return 0;
        
        if(steps <= 0) return (i == 0) ? 1 : 0;
        
        if(dp[i][steps] != null) return dp[i][steps];
        
        int stay = solve2(i, steps - 1, n, dp);
        int left = solve2(i - 1, steps - 1, n, dp);
        int right = solve2(i + 1, steps - 1, n, dp);
        
        return dp[i][steps] = ADD(stay, ADD(left, right));
    }
    
    /** Approach 3 : Tabulation
    *   Time Complexity --> O(n * steps) 
    *   Space Complexity --> O(n * steps)
    **/
    private int solve3(int n, int steps){
        Integer[][] dp = new Integer[steps + 1][n];
        dp[0][0] = 1;
        
        int left;
        int stay;
        int right;
        
        for(int step = 1; step <= steps; ++step){
            
            /**  If we are currently at pos j,
            *    we would require atleast 
            *    (j - i) steps to reach pos i
            *
            * => In other words, to return to pos from pos i
            *    we need atleast i steps
            * 
            * => Conversely, if we have `steps` number of steps,
            *    farthest we can reach from index 0 is 
            *      (0 + steps) = steps
            * 
            *  This would reduce time & space complexity to half times the original.
            **/
            
            int lim = Math.min(step, n - 1);
            for(int i = 0; i <= lim; ++i){ 
                
                left = (i > 0) ? dp[step - 1][i - 1] : 0;
                stay = (i < lim) ? dp[step - 1][i] : 0;
                right = (i < lim - 1) ? dp[step - 1][i + 1] : 0;
                
                dp[step][i] = ADD(stay, ADD(left, right));
            }
        }
        
        // Back to pos 0, after steps == `steps`
        return dp[steps][0];
    }
    
    public int numWays(int steps, int arrLen) {
        int effectiveSize = 1 + steps / 2;
        int n = Math.min(arrLen, effectiveSize);
        
        // return solve1(0, steps, n);
        return solve2(0, steps, n, new Integer[n][steps + 1]);
        // return solve3(n, steps);
    }
}