class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        
        int maxLen = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        int si = 0;
        for(int ei = 0; ei < nums.length; ++ei){
            freq.put(nums[ei], freq.getOrDefault(nums[ei], 0) + 1);
            
            if(freq.get(nums[ei]) > k){
                while(si < ei){
                    int curr = nums[si];
                    freq.put(curr, freq.get(curr) - 1);
                    si ++;
                    
                    if(curr == nums[ei]) break;
                }
            }
            
            maxLen = Math.max(maxLen, ei - si + 1);
        }
        
        return maxLen;
    }
}