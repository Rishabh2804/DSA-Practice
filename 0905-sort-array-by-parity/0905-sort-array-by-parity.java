class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        int n = nums.length;
        int lastEven = 0;
        
        for(int i = 0; i < n; ++i){
            if(nums[i] % 2 == 0){
                int temp = nums[i];
                nums[i] = nums[lastEven];
                nums[lastEven] = temp;
                
                lastEven++;
            }
        }
        
        return nums;
    }
}