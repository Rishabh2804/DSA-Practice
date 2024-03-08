class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        int maxFreq = 1;
        for(int i : nums){
            freq.putIfAbsent(i, 0);
            
            freq.put(i, freq.get(i) + 1);
            
            maxFreq = Math.max(maxFreq, freq.get(i));
        }
        
        int total = 0;
        for(int fr : freq.values()){
            if(fr == maxFreq) total += fr;
        }
        
        return total;
    }
}