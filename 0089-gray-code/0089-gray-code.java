class Solution {
    public List<Integer> grayCode(int n) {
        
        List<Integer> codes = new LinkedList<>();        
        codes.add(0);
        
        int bitPos = 0;
        while(bitPos < n){
            int mask = 1 << bitPos;
            
            int size = codes.size();
            for(int i = size - 1; i >= 0; --i){
                int grayCode = codes.get(i) | mask;
                codes.add(grayCode);
            }
            
            bitPos++;
        }
        
        return codes;
    }
}

// 111
// 011
// 001
// 000
// 010
// 110
// 100
// 101


// 000 100 110 010 011 111 101 001

// 111
// 011 111
// 001 101 111 011
// 000 100 110 010 011 111 101 001

// 111
// 111 011
// 111 011 001 101
// 111 011 001 101 100 000 010 110


// 0111 1111 1111 0111