class Solution {
    
    public int combinationSum4(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        int[] ways = new int[target + 1];
        ways[0] = 1;
        for(int i = 1; i <= target; ++i){
            for(int k : nums){
                if(k <= i)
                    ways[i] += ways[i - k];                
                else
                    break;
            }
        }
        
        return ways[target];
    }
    
}