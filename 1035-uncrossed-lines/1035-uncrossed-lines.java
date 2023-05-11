class Solution {
    public int solve(int si, int sj, int[] nums1, int[] nums2, int[][] dp){
        if(si >= nums1.length || sj >= nums2.length) return 0;
        
        if(dp[si][sj] != -1) return dp[si][sj];
        
        int ans = solve(si + 1, sj, nums1, nums2, dp);
        for(int i = sj; i < nums2.length; ++i){
            if(nums1[si] == nums2[i])
                ans = Math.max(ans, 1 + solve(si + 1, i + 1, nums1, nums2, dp));
        }
        
        return dp[si][sj] = ans;
    }
    
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        int[][] dp = new int[Math.max(n, m)][Math.min(n, m)];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        if(n >= m)
            return solve(0, 0, nums1, nums2, dp);
        else
            return solve(0, 0, nums2, nums1, dp);
        
        // for(int i )
    }
}

//  2 5 1 2 5
// 10 5 2 1 5 2 