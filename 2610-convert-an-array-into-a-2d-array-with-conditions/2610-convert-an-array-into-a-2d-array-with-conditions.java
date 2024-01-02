class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i : nums)
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        
        List<List<Integer>> mat = new ArrayList<>();
        while(!freq.isEmpty()){
            List<Integer> row = new ArrayList<>();
            for(Integer num : freq.keySet()){
                row.add(num);
                
                freq.put(num, freq.getOrDefault(num, 1) - 1);
            }    
            
            for(int num : row)
                if(freq.get(num) == 0) freq.remove(num);
            
            mat.add(row);
        }
        
        return mat;
    }
}