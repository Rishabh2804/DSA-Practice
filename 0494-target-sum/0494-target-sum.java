class Solution {
    
    public int solve(int i, int target, int[] nums){
        if(i >= nums.length) {
            if(target == 0) return 1;
            else return 0;
        }
        
        int add = solve(i + 1, target - nums[i], nums);
        int sub = solve(i + 1, target + nums[i], nums);
        
        return add + sub;
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<Integer, Integer> currFreq = new HashMap<>();
        HashMap<Integer, Integer> auxFreq = new HashMap<>();
        
        currFreq.put(0, 1);
        for(int ele : nums){
            for(int sum : currFreq.keySet()){
                int freq = currFreq.get(sum);
                
                // remove from curr level,
                // add to next level
                
                currFreq.put(sum, 0);        
                
                auxFreq.put(sum + ele, auxFreq.getOrDefault(sum + ele, 0) + freq);
                auxFreq.put(sum - ele, auxFreq.getOrDefault(sum - ele, 0) + freq);
            }
            
            // swap the two maps
            HashMap<Integer, Integer> temp = currFreq;
            currFreq = auxFreq;
            auxFreq = temp;
        }
        
        // return solve(0, target, nums);
        return currFreq.getOrDefault(target, 0);
    }
}