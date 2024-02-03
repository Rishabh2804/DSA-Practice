class Solution {
    private int solve(int si, int[] arr, int k, int[] dp){
        if(si >= arr.length) return 0;
        
        if(dp[si] != -1) return dp[si];
        
        int lim = Math.min(k, arr.length - si);
        int max = arr[si];
        int res = 0;
        
        for(int i = 0; i < lim; ++i){
            max = Math.max(max, arr[i + si]);
            res = Math.max(res, (i + 1) * max + solve(si + i + 1, arr, k, dp));
        }
        
        return dp[si] = res;
    }
    
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return solve(0, arr, k, dp);
    }
}