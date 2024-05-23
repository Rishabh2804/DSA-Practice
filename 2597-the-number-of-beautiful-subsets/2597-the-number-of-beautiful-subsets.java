class Solution {
    
    private boolean check(int x, List<Integer> list, int k){
        for(int i : list) {
            if(Math.abs(i - x) == k) 
                return false;
        }
        
        return true;
    }
    
    private List<List<Integer>> solve(int i, int[] nums, int k){        
        List<List<Integer>> sets;
        
        if(i >= nums.length) {
            sets = new ArrayList<>();
            sets.add(new ArrayList<>());
            return sets;
        }

        sets = solve(i + 1, nums, k);   
        int size = sets.size();
        for(int j = 0; j < size; ++j){
            List<Integer> set = sets.get(j);
            if(check(nums[i], set, k)){
                List<Integer> copy = new ArrayList<>(set);
                copy.add(nums[i]);
                sets.add(copy);
            }
        }
        
        return sets;
    }
    
    public int beautifulSubsets(int[] nums, int k) {
        List<List<Integer>> sets = solve(0, nums, k);
        // System.out.println(sets);
        
        return sets.size() - 1;
    }
}