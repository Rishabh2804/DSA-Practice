class Solution {
    public int longestSubarray(int[] nums) {
        
        int maxLen = 1;        
        int max = nums[0];
        int si = 0;
        for(int ei = 0; ei < nums.length; ++ei){
            if(nums[ei] == max) continue;
            
            if(nums[ei] < max) {
                maxLen = Math.max(maxLen, ei - si);
                si = ei + 1;
            } else {
                max = nums[ei];
                maxLen = 1;
                si = ei;
            }
        }
        
        if(nums[nums.length - 1] == max)
            maxLen = Math.max(maxLen, nums.length - si);
        
        return maxLen;
    }
}