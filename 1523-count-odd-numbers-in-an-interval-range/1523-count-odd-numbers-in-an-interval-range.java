class Solution {
    public int countOdds(int low, int high) {        
        int len = high - low + 1;
        
        if(len % 2 == 1){
            if(high % 2 == 1)
                if(low % 2 == 1)
                    len ++;
        }
        
        return len >> 1;
    }
}