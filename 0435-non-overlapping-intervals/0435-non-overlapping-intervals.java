class Solution {
    static final int SI = 0;
    static final int EI = 1;
    static final int MIN_END_TIME = -1000000;
    
    private int lowerBound(int si, int[][] arr, int lim){
        
        int ei = arr.length - 1;
        while(si < ei){
            int mid = (si + ei) / 2;
            if(arr[mid][SI] < lim) si = mid + 1;
            else ei = mid;
        }
        
        if(si < arr.length && arr[si][SI] < lim) return si + 1;
        else return si;
    }
    
    private int solve(int i, int[][] intervals, int[] dp){
        if(i >= intervals.length) return 0;
        
        if(dp[i] != -1) return dp[i];
        
        int leave = solve(i + 1, intervals, dp);
        
        int nextIntervalIdx = lowerBound(i + 1, intervals, intervals[i][EI]);
        
        int take = 1;
        if(nextIntervalIdx < intervals.length)
            take = 1 + solve(nextIntervalIdx, intervals, dp); 
        
        return dp[i] = Math.max(take, leave);
    }
    
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] dp = new int[intervals.length];
        Arrays.fill(dp, -1);
        
        int maxIntervals = solve(0, intervals, dp);
        return intervals.length - maxIntervals;
    }
}