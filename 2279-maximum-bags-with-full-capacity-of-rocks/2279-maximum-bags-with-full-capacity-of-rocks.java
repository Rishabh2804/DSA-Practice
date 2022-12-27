class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for(int i = 0; i < rocks.length; ++i)
            capacity[i] -= rocks[i];
        
        Arrays.sort(capacity);
        for(int i = 0; i < capacity.length; ++i){
            if(capacity[i] > additionalRocks)
                return i;
            
            additionalRocks -= capacity[i];
            capacity[i] = 0;
        }
        
        return capacity.length;
    }
}