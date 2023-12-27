class Solution {
    
    public int minCost(String colors, int[] neededTime) {
        if(colors.length() <= 1) return 0;
        
        int n = colors.length();        
        int cost = 0;
        
        int maxCost = neededTime[0];        
        int groupCost = neededTime[0];
        for(int i = 1; i < n; ++i){
            if(colors.charAt(i) != colors.charAt(i - 1)) {                
                cost += groupCost - maxCost;
                groupCost = 0;
                maxCost = 0;
            }
            
            groupCost += neededTime[i];
            maxCost = Math.max(maxCost, neededTime[i]);
        }
        
        cost += groupCost - maxCost;
        
        return cost;
    }
}