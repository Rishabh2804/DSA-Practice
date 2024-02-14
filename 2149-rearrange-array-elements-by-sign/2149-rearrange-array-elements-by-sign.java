class Solution {
    
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        
        Queue<Integer> pos = new LinkedList<>();
        Queue<Integer> neg = new LinkedList<>();
        
        for(int i = 0; i < n; ++i){                
            if(nums[i] > 0) pos.add(nums[i]);
            else neg.add(nums[i]);
        }
        
        for(int i = 0; i < n; i += 2)   nums[i] = pos.poll();
        for(int i = 1; i < n; i += 2)   nums[i] = neg.poll();
        
        return nums;
    }
}