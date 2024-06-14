class Solution {
    public int minIncrementForUnique(int[] nums) {
        
        int count = 0;
        Arrays.sort(nums);
        int max = -1;
        for(int i = 0; i < nums.length; ++i){
            if(max == -1){
                max = nums[i];
                continue;
            }
            
            if(max >= nums[i]){
                int target = max + 1;
                count += target - nums[i];
                max = target;
            } else max = nums[i];
        }        
        
        return count;
    }
}