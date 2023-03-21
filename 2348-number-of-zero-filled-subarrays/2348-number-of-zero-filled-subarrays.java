class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        long count = 0;
        long zeroes = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 0)
                zeroes++;
            else{                
                count += zeroes * (zeroes + 1) / 2;
                zeroes = 0;
            }
        }
        
        count += zeroes * (zeroes + 1) / 2;
        return count;
    }
}