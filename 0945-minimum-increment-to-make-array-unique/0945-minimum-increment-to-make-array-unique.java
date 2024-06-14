class Solution {
    public int minIncrementForUnique(int[] nums) {
        
        int count = 0;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; ++i){
            if(list.isEmpty()){
                list.add(nums[i]);
                continue;
            }
            
            if(list.get(list.size() - 1) >= nums[i]){
                int target = list.get(list.size() - 1) + 1;
                count += target - nums[i];
                list.add(target);
            } else list.add(nums[i]);                        
        }        
        
        return count;
    }
}