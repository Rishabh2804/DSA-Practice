class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        int[] totalCost = new int[n + 1];
        
        for(int i = 2; i <= n; ++i){
            int cost1 = totalCost[i - 1] + cost[i - 1];
            int cost2 = totalCost[i - 2] + cost[i - 2];

            totalCost[i] = Math.min(cost1, cost2);
        }
        
        return totalCost[n];
    }
}