class Solution {
    
    public int solve(int i, int toBuy, int[] prices, int fee, int[][] dp){
        if(i >= prices.length) return 0;
        
        if(dp[i][toBuy] != -1) return dp[i][toBuy];
        
        int leave = solve(i + 1, toBuy, prices, fee, dp);
        
        int take = 0;
        
        take = solve(i + 1, 1 - toBuy, prices, fee, dp);                
        if(toBuy == 1)
            take -= prices[i] + fee; // price of stock + transact fee
        else
            take += prices[i]; // profit from stock;
        
        
        return dp[i][toBuy] = Math.max(leave, take);
    }
    
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return solve(0, 1, prices, fee, dp);
    }
}