class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        HashMap<Integer, Integer> reg = new HashMap<>();
        reg.put(0, 1);
        
        int count = 0;
        
        int sum = 0;
        for(int ele : nums){
            sum += ele;
            
            count += reg.getOrDefault(sum - goal, 0);
            reg.put(sum, reg.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}