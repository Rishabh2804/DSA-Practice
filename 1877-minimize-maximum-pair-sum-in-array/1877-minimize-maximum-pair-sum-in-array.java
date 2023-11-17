class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;

        int maxSum = 0;
        for(int i = 0; i < n; ++i){
            int currPair = nums[i] + nums[n - i - 1];
            maxSum = Math.max(maxSum, currPair);
        }
        
        return maxSum;
    }
}