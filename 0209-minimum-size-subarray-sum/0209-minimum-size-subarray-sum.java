class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = nums.length + 1;
        
        int si = 0, ei = 0;
        int sum = 0;
        while(ei < nums.length){
            sum += nums[ei];
            if(sum >= target){
                while(sum >= target && si <= ei){
                    sum -= nums[si++];         
                }   
                minLen = Math.min(minLen, ei - si + 2);            
            }
            ei++;
        }
        
        if(minLen > nums.length) return 0;
        else return minLen;
    }
}