class Solution {
    
    private static final int[] bits = new int[32];
    
    private int[] getBits(int num){
        
        Arrays.fill(bits, -1);
        
        int bit = 0;
        while(bit < bits.length){ 
            if(num == 0) break;
            
            bits[bit++] = num & 1;
            num >>= 1;            
        }
        
        return bits;
    }
    
    public int findComplement(int num) {
        
        int[] bits = getBits(num);
        
        int res = 0;
        for(int i = bits.length - 1; i >= 0; --i){
            if(bits[i] == -1) continue;
            
            res <<= 1;
            res |= bits[i] ^ 1;
        }
        
        return res;
    }
}