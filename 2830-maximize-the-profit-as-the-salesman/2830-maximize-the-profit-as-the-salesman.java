class Solution {
    static final int START = 0;
    static final int END   = 1;
    static final int GOLD  = 2;
    
    private int lowerBound(int si, int x, List<List<Integer>> offers) {
        int ei = offers.size();
        
        int ans = -1;
        while(si < ei) {
            int mid = (si + ei) / 2;
            if(offers.get(mid).get(START) > x){                
                ei = mid;
                ans = mid;
            }
            else si = mid + 1;
        }        
        
        return si;
    }
    
    public int solve(int i, List<List<Integer>> offers, int[] dp){
        if(i >= offers.size()) return 0;
        
        if(dp[i] != -1) return dp[i];
        
        int leave = solve(i + 1, offers, dp);
                
        int take = offers.get(i).get(GOLD);
        int nextIdx = lowerBound(i + 1, offers.get(i).get(END), offers);
        // if (nextIdx != -1)
            take += solve(nextIdx, offers, dp);
        
        return dp[i] = Math.max(leave, take);
    }
    
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers, (a, b) -> a.get(START) - b.get(START));
        
        int[] dp = new int[offers.size()];
        Arrays.fill(dp, -1);

        int ans = solve(0, offers, dp);
        
        return ans;
    }
}