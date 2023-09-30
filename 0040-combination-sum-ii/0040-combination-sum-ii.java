class Solution {
    
    HashSet<List<Integer>> set;
    
    private void solve(int i, int target, List<int[]> list, List<Integer> combo){
        if(target == 0){
            set.add(new ArrayList<>(combo));
            return;
        }
        
        if(i >= list.size()) return;

        int[] curr = list.get(i);
        int val = curr[0];
        int freq = curr[1];
                
        for(int k = 0; k <= freq; ++k){
            if(target < k * val) break;
            
            for(int j = 0; j < k; ++j) combo.add(val);
            
            solve(i + 1, target - k * val, list, combo);
            
            for(int j = 0; j < k; ++j) combo.remove(combo.size() - 1);
        }
    }
   
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {        
        set = new HashSet<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i : candidates)
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        
        List<int[]> list = new ArrayList<>();
        for(Integer candidate : freq.keySet())
            list.add(new int[]{candidate, freq.get(candidate)});
        
        solve(0, target, list, new ArrayList<>());
        
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> combo : set)
            res.add(combo);
        
        return res;
    }
}