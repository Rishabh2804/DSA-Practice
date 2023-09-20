class Solution {
    public int minOperations(int[] nums, int x) {
        
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); //reference index for the exact sum value
        map.put(sums[0], 0);
        for(int i = 1; i < nums.length; ++i){
            sums[i] = sums[i - 1] + nums[i];
            map.put(sums[i], i);            
        }       
        
        int tSum = sums[sums.length - 1]; //total sum of array elements
        int rSum = tSum - x; // required sum of longest subarray
        
        if(rSum == 0)
            return nums.length;
        
        int maxLen = 0;
        for(int i = 0; i < sums.length; ++i){
            
            //default value set to i to make len = 0 for no subarray present
            int len = i - map.getOrDefault(sums[i] - rSum, i); 
            maxLen = Math.max(maxLen, len);             
        }
        
        return (maxLen == 0) ? -1 : nums.length - maxLen;        
    }
}

//1 2 6 8 11