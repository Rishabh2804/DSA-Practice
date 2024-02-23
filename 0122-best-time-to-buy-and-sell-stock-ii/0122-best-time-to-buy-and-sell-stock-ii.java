class Solution {
    
    private int solve(int i, int[] prices, int[] dp){
        if(i >= prices.length) return 0;
        
        if(dp[i] != -1) return dp[i];
        
        int maxProfit = 0;
        for(int j = i; j < prices.length; ++j){
            int currProfit = prices[j] - prices[i];
            int postProfit = solve(j + 1, prices, dp);
            
            maxProfit = Math.max(maxProfit, currProfit+ postProfit);            
        }
        
        return dp[i] = maxProfit;
    }
    
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return solve(0, prices, dp);
    }
}