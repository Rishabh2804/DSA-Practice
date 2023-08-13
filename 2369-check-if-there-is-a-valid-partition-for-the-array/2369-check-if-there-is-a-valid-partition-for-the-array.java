class Solution {
    public boolean solve(int i, int[] nums, Boolean[] dp){        
        if(i == nums.length - 1) return false;
        if(i >= nums.length) return true;        
        
        if(dp[i] != null) return dp[i];
        
        boolean ans = false;
                
        if(i <= nums.length - 3) {
            if(nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]){
                ans = solve(i + 3, nums, dp);
                if(ans) return dp[i] = ans;
            } else if((1 + nums[i]) == nums[i + 1] && (1 + nums[i + 1]) == nums[i + 2]) {
                ans = solve(i + 3, nums, dp);
                if(ans) return dp[i] = ans;
            }            
        } 
        
        if(nums[i] == nums[i + 1])
            ans = solve(i + 2, nums, dp);
            
        return dp[i] = ans;
    }
    
    public boolean validPartition(int[] nums) {
        return solve(0, nums, new Boolean[nums.length]);
    }
}