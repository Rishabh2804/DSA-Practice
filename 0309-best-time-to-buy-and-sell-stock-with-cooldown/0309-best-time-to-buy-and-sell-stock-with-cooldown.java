class Solution {
    public int maxProfit(int[] prices) {

        return getMaxProfit(0,prices,0,new Integer[prices.length][2]);
    }
    public int getMaxProfit(int index, int[] prices, int buyOrSell, Integer[][] dp)
    {
        if(index >=prices.length)
            return 0;
        if(dp[index][buyOrSell]!= null)
            return dp[index][buyOrSell];
        int result;
        if(buyOrSell==0)
        {
            result = Math.max(getMaxProfit(index+1, prices,buyOrSell,dp),getMaxProfit(index+1, prices,1,dp)-prices[index]);
        }
        else{
            result = Math.max(getMaxProfit(index+1, prices,buyOrSell,dp),getMaxProfit(index+2, prices,0,dp)+prices[index]);
        }
        return dp[index][buyOrSell] = result;
    }
}