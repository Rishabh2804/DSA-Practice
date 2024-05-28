class Solution {
    
    private boolean check(int[] cost, int x, int len){
        
        int currCost = 0;
        for(int i = 0; i < len; ++i) currCost += cost[i];
        
        if(currCost <= x) return true;
        
        for(int i = len; i < cost.length; ++i){
            currCost -= cost[i - len];
            currCost += cost[i];
            
            if(currCost <= x) return true;
        }
        
        return false;
    }
    
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] cost = new int[n];
        for(int i = 0; i < n; ++i){
            int diff = Math.abs(s.charAt(i) - t.charAt(i));
            cost[i] = diff;
        }
        
        int si = 0, ei = n;
        while(si < ei){
            int mid = (si + ei + 1) / 2;
            if(check(cost, maxCost, mid)) si = mid;
            else ei = mid - 1;
        }
        
        return ei;
    }
}