class Solution {
    private int lowerBound(int i, int[][] pairs, int x){
        int si = i;
        int ei = pairs.length;
        
        while(si < ei){
            int mid = (si + ei) / 2;
            if(pairs[mid][0] > x)
                ei = mid;
            else 
                si = mid + 1;
        }
        
        return si;
    }
    
    private int solve(int i, int[][] pairs, Integer[] dp){
        if(i >= pairs.length) return 0;
        
        if(dp[i] != null) return dp[i];
        
        int leave = solve(i + 1, pairs, dp);
        int take = 1;
        int nextPair = lowerBound(i + 1, pairs, pairs[i][1]);
        if(nextPair < pairs.length)
            take += solve(nextPair, pairs, dp);
        
        return dp[i] = Math.max(leave, take);
    }
    
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        return solve(0, pairs, new Integer[pairs.length]);
    }
}