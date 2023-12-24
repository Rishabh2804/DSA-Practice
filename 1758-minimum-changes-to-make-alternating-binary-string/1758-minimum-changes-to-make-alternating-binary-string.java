class Solution {
    // Let's take min of 2 permutations: 
    // - all odd pos 0, all even pos 1
    // - all even pos 1, all odd pos 0
    
    static final boolean TYPE_0 = true;  // starting with 0
    static final boolean TYPE_1 = false; // starting with 1
    
    private int countOp(boolean type, String s){
        int count = 0;
        
        for(int i = 0; i < s.length(); ++i){
            int curr = s.charAt(i) - '0';
            
            // if followes og pattern : 010101 -> type_0, 1010101 -> type_1
            boolean correct = type ^ (i % 2 == curr);
            
            if(!correct) count++;
        }
        
        return count;
    }
    
    public int minOperations(String s) {
        return Math.min(countOp(TYPE_0, s), countOp(TYPE_1, s));    
    }
}