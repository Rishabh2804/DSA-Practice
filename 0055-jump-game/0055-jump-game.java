class Solution {
    public boolean canJump(int[] nums) {
        
        int ei = 0;
        for(int i = 0; i <= ei; ++i){
//             if(i == nums.length)
//                 return true;
            
            ei = Math.max(ei, i + nums[i]);
            
            if(ei >= nums.length - 1)
                return true;
        }
        
        return false;
    }
}