class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        boolean[] present = new boolean[n];
        
        List<Integer> res = new ArrayList<>();
        for(int i : nums){
            if(present[i - 1]) res.add(i);
            
            present[i - 1] = true;
        }
        
        return res;
    }
}