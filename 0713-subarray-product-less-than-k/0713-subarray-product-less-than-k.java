class Solution {
    
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int si = 0;
        int count = 0;
        
        int currProd = 1;
        for(int ei = 0; ei < nums.length; ++ei){
            
            currProd *= nums[ei];
            
            while(currProd >= k && si <= ei){
                currProd /= nums[si];
                si ++;
            }
            
            count += (ei - si + 1);
        }
        
        return count;
    }
}