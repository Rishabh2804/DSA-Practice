class Solution {
    
    public int solve(int i, int target, int[] nums){
        if(i >= nums.length) {
            if(target == 0) return 1;
            else return 0;
        }
        
        int add = solve(i + 1, target - nums[i], nums);
        int sub = solve(i + 1, target + nums[i], nums);
        
        return add + sub;
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0, target, nums);
    }
}