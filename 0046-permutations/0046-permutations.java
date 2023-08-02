class Solution {
    
    private List<List<Integer>> solve(int si, int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        
        if(si == nums.length - 1){
            List<Integer> list = new ArrayList<>();
            list.add(nums[si]);            
            res.add(list);
            return res;
        }
        
        List<List<Integer>> rest = solve(si + 1, nums);
        for(int i = 0; i < rest.size(); ++i){
            List<Integer> curr = rest.get(i);
            for(int j = 0; j < curr.size(); ++j){
                List<Integer> copy = new ArrayList<>(curr);
                copy.add(j, nums[si]);
                res.add(copy);
            }
            List<Integer> copy = new ArrayList<>(curr);
            copy.add(nums[si]);
            res.add(copy);            
        }
        
        return res;
    } 
    
    public List<List<Integer>> permute(int[] nums) {
        return solve(0, nums);
    }
}