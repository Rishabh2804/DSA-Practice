class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i <= Math.min(k, nums.length - 1); ++i){
            
            if(map.containsKey(nums[i]))
                return true;
            
            map.put(nums[i], true);
        }
        
        if(k >= nums.length)
            return false;
        
        for(int i = k + 1; i < nums.length; ++i){
            map.remove(nums[i - k - 1]);
            
            if(map.containsKey(nums[i]))
                return true;
            
            map.put(nums[i], true);
        }
        
        return map.size() <= k;
    }
}