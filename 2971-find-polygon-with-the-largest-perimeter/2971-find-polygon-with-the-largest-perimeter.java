class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;
        long sum = nums[0] + nums[1];
        
        long maxPer = -1;
        int i = 2;
        while(i < n){
            if(sum > nums[i]) maxPer = sum + nums[i];
            
            sum += nums[i];
            i++;
        }
        
        return maxPer;            
    }
}