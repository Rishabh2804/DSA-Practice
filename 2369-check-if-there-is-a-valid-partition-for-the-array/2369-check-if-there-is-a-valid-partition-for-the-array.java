class Solution {
    
    public boolean validPartition(int[] nums) {
        
        int n = nums.length;        
        boolean[] dp = new boolean[n];
        
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
            
            // two equal elements
            if(nums[i] == nums[i - 1]){
                if(i == 1) dp[i] = true;
                else dp[i] |= dp[i - 2];
            }
        }
        
        return dp[n - 1];
    }
}