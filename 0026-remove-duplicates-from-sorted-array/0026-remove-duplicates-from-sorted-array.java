class Solution {
    public int removeDuplicates(int[] nums) {
        
        int j = 0;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] != nums[j]){
                j++;

                nums[j] = nums[i];
                // int temp = nums[i];
                // nums[i] = nums[j];
                // nums[j] = temp;
            }
        }
        
        return j + 1;
    }
}