class Solution {
    public int partitionString(String s) {
        int count = 1;
        int mask = 0;
        for(int i = 0; i < s.length(); ++i){
            int idx = s.charAt(i) - 'a';
            int bit = 1 << idx;
            
            if((bit & mask) == 0)
                mask |= bit;
            else {
                mask = bit;
                count++;                    
            }
        }
        
        return count;
    }
}