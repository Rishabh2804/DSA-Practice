class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        
        int count = 0;
        int prefixSum = 0;
        for(int num : nums){
            prefixSum += num;            
            prefixSum %= k;
            
            if(prefixSum < 0)
                prefixSum += k;
            
            count += freq.getOrDefault(prefixSum, 0);
            
            freq.put(prefixSum, freq.getOrDefault(prefixSum, 0) + 1);    
        }
        
        return count;
    }
}


// 4 9 9 7 4 5
// 4 4 4 2 4 0