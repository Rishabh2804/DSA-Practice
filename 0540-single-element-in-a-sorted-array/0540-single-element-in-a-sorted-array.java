class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int si = 0, ei = nums.length - 2;
        while(si < ei){
            int mid = (si / 2 + ei / 2) / 2;
            mid *= 2;
            
            if(nums[mid] == nums[mid + 1])
                si = mid + 2;
            else 
                ei = mid - 1;            
        }
        
        return nums[ei + 1];
    }
}