class Solution {
    static final int MAX_SIZE = 100;
    
    public int numIdenticalPairs(int[] nums) {
        int[] freq = new int[MAX_SIZE + 1];
        for(int num : nums)
            freq[num]++;
        
        int count = 0;
        for(int i : freq)
            count += (i * (i - 1)) / 2;
        
        return count;
    }
}