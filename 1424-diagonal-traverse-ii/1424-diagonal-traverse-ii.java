class Solution {
    
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        TreeMap<Integer, List<Integer>> reg = new TreeMap<>();
        
        int length = 0;
        for(int i = 0; i < nums.size(); ++i){
            int m = nums.get(i).size();
            length += m;
            
            for(int j = 0; j < m; ++j){
                List<Integer> currList = reg.getOrDefault(i + j, new ArrayList<>());
                currList.add(nums.get(i).get(j));
                
                reg.put(i + j, currList);
            }
        }
        
        int[] traversal = new int[length];
        int i = 0;
        for(List<Integer> list : reg.values()){
            for(int j = list.size() - 1; j >= 0; --j) 
                traversal[i++] = list.get(j);
        }
        
        return traversal;
    }
}