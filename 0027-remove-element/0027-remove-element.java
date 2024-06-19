class Solution {
    public int removeElement(int[] nums, int val) {
        
        int ei = nums.length - 1;
        while(ei >= 0 && nums[ei] == val) ei --;
        
        for(int i = 0; i <= ei; ++i){  
            
            if(nums[i] == val){
                nums[i] = nums[ei];
                nums[ei] = val;
                ei--;
            }        
            
            while(ei >= 0 && nums[ei] == val) ei --;
            
        }
        
        return ei + 1;
    }
}