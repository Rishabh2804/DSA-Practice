class Solution {
    
    List<List<Integer>> subsequences;
    HashSet<List<Integer>> visited;
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        subsequences = new ArrayList<>();
        // visited = new boolean[nums.length + 1][nums.length + 1];
        visited = new HashSet<>();
        
        solve(0, -1, new ArrayList<>(), nums);
        
        return subsequences;
    }
    
    void solve(int i, int prevI, List<Integer> curr, int[] nums){
        if(i >= nums.length)
            return;        
             
        if(prevI == -1 || nums[prevI] <= nums[i]){    
            List<Integer> take = new ArrayList<>(curr);
            take.add(nums[i]);
            
            if(!visited.contains(take)){
                visited.add(take);
                
                solve(i + 1, i, take, nums);
                if(take.size() >= 2)
                    subsequences.add(take);                        
            }
        }

        // curr acts as "leave" pov list
        solve(i + 1, prevI, curr, nums);        
        if(!visited.contains(curr) && curr.size() >= 2)
            subsequences.add(curr);                    
    } 
}