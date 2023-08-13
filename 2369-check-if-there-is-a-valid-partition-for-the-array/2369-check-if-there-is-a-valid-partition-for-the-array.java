class Solution {
    public boolean solve(int i, int[] nums, Boolean[] dp){        
        if(i == nums.length - 1) return false;
        if(i >= nums.length) return true;        
        
        if(dp[i] != null) return dp[i];
        
        boolean ans = false;
                
        if(i <= nums.length - 3) {
            if(nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2])
                ans = solve(i + 3, nums, dp);              
            else if((1 + nums[i]) == nums[i + 1] && (1 + nums[i + 1]) == nums[i + 2]) 
                ans = solve(i + 3, nums, dp);
        } 
        
        if(ans) return dp[i] = ans;
        
        if(nums[i] == nums[i + 1])
            ans = solve(i + 2, nums, dp);
            
        return dp[i] = ans;
    }
    
    public boolean validPartition(int[] nums) {
        
        int n = nums.length;        
        boolean[] dp = new boolean[n];
        // dp[0] = true;
        
        for(int i = 1; i < nums.length; ++i){
            if(i >= 2){
                // three equal elements
                if(nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2]){
                    if(i == 2) dp[i] = true;
                    else dp[i] = dp[i - 3];
                }
                // three consecutive elements
                else if((nums[i] - 1) == nums[i - 1] && (nums[i - 1] - 1) == nums[i - 2]){
                    if(i == 2) dp[i] = true;
                    else dp[i] = dp[i - 3];
                }
            }
            
            if(dp[i]) continue;
            
            // two equal elements
            if(nums[i] == nums[i - 1]){
                if(i == 1) dp[i] = true;
                else dp[i] = dp[i - 2];
            }
        }
        
        return dp[n - 1];
    }
}