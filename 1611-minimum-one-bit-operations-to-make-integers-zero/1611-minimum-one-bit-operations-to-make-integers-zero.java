class Solution {
    public int minimumOneBitOperations(int n) {
        
        int op = 0;
        
        for(int bit = 0; bit < 32; ++bit){
            int currBit = 1 << bit;
            
            if((n & currBit) != 0){
                
                int reqOp = (currBit << 1) - 1;
                int savedOp = op;
                
                op = reqOp - savedOp;
            }
        }
        
        return op;
    }
}