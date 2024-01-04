class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i : nums){
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        
        int count = 0;
        for(Integer i : freq.keySet()){
            int f = freq.get(i);
            
            if(f == 1) return -1;
            
            count += f / 3;
            if(f % 3 != 0) count++;
        }
        
        return count;
    }
}