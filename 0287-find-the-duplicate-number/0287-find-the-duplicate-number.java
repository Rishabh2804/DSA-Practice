class Solution {    
    
    private int brute(int[] nums){
        int n = nums.length;
        for(int i = 0; i < n; ++i){
            for(int j = i + 1; j < n; ++j){
                if(nums[i] == nums[j]) return nums[i];
            }                
        }
        
        return -1; // will never reach here
    }
    
    private int countFind(int[] nums){
        int n = nums.length;
        int[] freq = new int[n];
        for(int i : nums){
            freq[i - 1]++;
            
            if(freq[i - 1] > 1) return i;
        }
        
        return -1; // will never reach here
    }
    
    public int findDuplicate(int[] nums) {
        
        return countFind(nums);
    }
}