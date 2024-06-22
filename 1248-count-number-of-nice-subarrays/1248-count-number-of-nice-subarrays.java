class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int oddCount = 0;
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        for(int i = 0; i < nums.length; ++i){
            oddCount += nums[i] % 2;
            count += freq.getOrDefault(oddCount - k, 0);            
            
            freq.put(oddCount, freq.getOrDefault(oddCount, 0) + 1);
        }
        
        // count += freq.getOrDefault(oddCount - k, 0);
        return count;
    }
}