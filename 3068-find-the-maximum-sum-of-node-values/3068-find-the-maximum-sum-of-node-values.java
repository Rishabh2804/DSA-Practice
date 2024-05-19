class Solution {
    
    private static final long NULL = -10000000000L;
    
    private long solve(int i, int k, int flag, int[] nums, long[][] dp){        
        if(i >= nums.length){
            if(flag == 0) return 0;
            else return NULL;
        }
        
        if(dp[i][flag] != -1L) return dp[i][flag];
        
        long op1 = nums[i] + solve(i + 1, k, flag, nums, dp);
        long op2 = (nums[i] ^ k) + solve(i + 1, k, 1 - flag, nums, dp);
        
        return dp[i][flag] = Math.max(op1, op2);
    }
    
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        
        long[][] dp = new long[nums.length][2];
        for(long[] row : dp) Arrays.fill(row, -1L);
        
        long ans = solve(0, k, 0, nums, dp);
        
        return ans;
    }
}

// 1 2 1
// 2 1 2

// 2 3
// 5 4

// 24 78 1 97 44

// 30 + 78 + 7 + 103 + 44

