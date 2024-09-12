class Solution {
    
    private static final int SIZE = 26;
    private static final int[] MASKS;
    static {
        
        MASKS = new int[SIZE];
        for(int i = 0; i < SIZE; ++i)
            MASKS[i] = 1 << i;
                
    }
    
    private int generateMask(String allowed){
        int mask = 0;
        
        for(int i = 0; i < allowed.length(); ++i)
            mask |= MASKS[allowed.charAt(i) - 'a'];
        
        return mask;
    }
    
    private boolean isConsistent(String word, int mask){
        for(int i = 0; i < word.length(); ++i){
            int curr = MASKS[word.charAt(i) - 'a'];
            if((curr & mask) == 0) return false;
        }
        
        return true;
    }
    
    public int countConsistentStrings(String allowed, String[] words) {
        
        int count = 0;
        int mask = generateMask(allowed);
        
        for(String word : words) {
            if(isConsistent(word, mask)) 
                count ++;
        }
        
        return count;
    }
}