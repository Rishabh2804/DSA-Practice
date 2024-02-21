class Solution {
    
    static final int SET_BUFFER = Integer.MAX_VALUE;
    
    public int rangeBitwiseAnd(int left, int right) {
        
        int rangeLen = right - left + 1;
        
        int res = left;
        
        int currBit = 1;
        int maxLen = currBit;
        for(int i = 0; i < 31; ++i){
            
            int startBit = currBit & left;
            int endBit = currBit & right;
            
            if((startBit & endBit) == 0 || rangeLen > maxLen) {                
                int complement = currBit ^ SET_BUFFER;
                
                res = res & complement;
            }
            
            currBit <<= 1;
            maxLen = currBit;
        }
        
        return res;
    }
}