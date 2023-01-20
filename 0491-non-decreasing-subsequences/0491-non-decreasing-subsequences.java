class Solution {
    
    // List<List<Integer>> subsequences;
    HashSet<List<Integer>> subsequences;
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        // subsequences = new ArrayList<>();
        // visited = new boolean[nums.length + 1][nums.length + 1];
        subsequences = new HashSet<>();
        
        solve(0, -1, new ArrayList<>(), nums);
        
        List<List<Integer>> list = new ArrayList<>();
        for(List<Integer> l : subsequences)
            list.add(l);
        
        return list;
    }
    
    void solve(int i, int prevI, List<Integer> curr, int[] nums){
        if(i >= nums.length)
            return;        
             
        if(prevI == -1 || nums[prevI] <= nums[i]){    
            List<Integer> take = new ArrayList<>(curr);
            take.add(nums[i]);
            
            solve(i + 1, i, take, nums);
            if(take.size() >= 2) {
                subsequences.add(take);        
            }
        }
        
        List<Integer> leave = curr;
        solve(i + 1, prevI, leave, nums);
        if(leave.size() >= 2){
            subsequences.add(leave);
        }
        
        // visited.add(curr);
    } 
}