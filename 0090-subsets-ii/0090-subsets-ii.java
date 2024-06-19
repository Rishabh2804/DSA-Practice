class Solution {
    
    static final int MASK_LEN = 10;
    
    private List<Integer> formList(int x, int freq){
        List<Integer> list = new ArrayList<>();
        while(freq --> 0) list.add(x);
        return list;
    }
    
    private List<List<Integer>> solve(int i, HashMap<Integer, List<List<Integer>>> map){
        List<List<Integer>> res;
        if(i > 10) {
            res = new ArrayList<>();
            res.add(new ArrayList<>());
            
            return res;
        }
        
        if(!map.containsKey(i)) return solve(i + 1, map);
        
        res = solve(i + 1, map);
        int size = res.size();
        for(int j = 0; j < size; ++j){
            List<Integer> curr = res.get(j);
            
            for(List<Integer> list : map.get(i)){
                List<Integer> copy = new ArrayList<>(list);
                copy.addAll(curr);
                res.add(copy);
            }
        }
        
        return res;
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {        
        int[] freq = new int[21];
        for(int i : nums) freq[i + 10] ++;
        
        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
        for(int i = -10; i <= 10; ++i){
            if(freq[i + 10] == 0) continue;
            
            List<List<Integer>> all = new ArrayList<>();
            for(int j = 1; j <= freq[i + 10]; ++j)
                all.add(formList(i, j));
            
            map.put(i, all);
        }
        
        return solve(-10, map);
    }
}