class Solution {
    public int longestSubarray(int[] nums) {
        if(nums.length <= 1) return 0;
        
        int n = nums.length;
        
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = nums[0];
        for(int i = 1; i < n; ++i)
            left[i] = nums[i] * (nums[i] + left[i - 1]);
        
        right[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; --i)
            right[i] = nums[i] * (nums[i] + right[i + 1]);
        
        int max = right[1];
        for(int i = 1; i < n - 1; ++i)
            max = Math.max(max, left[i - 1] + right[i + 1]);        
        
        max = Math.max(max, left[n - 2]);
        return max;
    }
}