class Solution {
    
    private int generateMask(String allowed){
        int mask = 0;
        
        for(int i = 0; i < allowed.length(); ++i)
            mask |= 1 << (allowed.charAt(i) - 'a');
        
        return mask;
    }
    
    private boolean isConsistent(String word, int mask){
        for(int i = 0; i < word.length(); ++i){
            int curr = 1 << (word.charAt(i) - 'a');
            if((curr & mask) == 0) return false;
        }
        
        return true;
    }
    
    public int countConsistentStrings(String allowed, String[] words) {
        
        int count = 0;
        int mask = generateMask(allowed);
        
        for(String word : words)
            count += isConsistent(word, mask) ? 1 : 0;
        
        return count;
    }
}