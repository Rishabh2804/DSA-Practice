class Solution {
    public int minBitFlips(int start, int goal) {
        
        int count = 0;
        while(start != 0 || goal != 0){
            int bit1 = start & 1;
            int bit2 = goal & 1;
            
            count += bit1 ^ bit2;
            
            start >>= 1;
            goal >>= 1;
        }
        
        return count;
    }
}