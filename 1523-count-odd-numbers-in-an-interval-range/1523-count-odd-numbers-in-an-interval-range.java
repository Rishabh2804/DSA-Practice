class Solution {
    public int countOdds(int low, int high) {        
        int len = high - low + 1;
        
        if((len & 1) == 1){
            if((high & low & 1) == 1)
                len += 2;
        }
        
        return len >> 1;
    }
}