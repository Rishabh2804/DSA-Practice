class Solution {
    public int reductionOperations(int[] nums) {
        int n = nums.length;
        
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        
        for(int ele : nums)
            freq.put(ele, freq.getOrDefault(ele, 0) + 1);            
        
        int op = 0;
        int lowFreq = 0;
        
        for(Integer ele : freq.keySet()){
            lowFreq += freq.get(ele);
            op += n - lowFreq;
        }
                
        return op;
    }
}