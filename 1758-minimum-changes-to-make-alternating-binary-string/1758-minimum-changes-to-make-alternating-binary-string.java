class Solution {
    // Let's take min of 2 permutations: 
    // - all odd pos 0, all even pos 1
    // - all even pos 1, all odd pos 0
    
    static final boolean TYPE_0 = true;  // starting with 0
    static final boolean TYPE_1 = false; // starting with 1
    
    // checking both ways by flipping
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
    
    
    // checking ways by frequency count of 1s and 0s
    private int countFreq(String s){
        int n = s.length();
                  
        int[] freq_odd = new int[2];
        int[] freq_even = new int[2];
        
        for(int i = 0; i < n; ++i){
            int curr = s.charAt(i) - '0';
            
            if(i % 2 == 0) freq_even[curr]++;
            else freq_odd[curr]++;
        }
        
        // 01010101
        int way1 = freq_odd[0] + freq_even[1];
        
        // 10101010
        int way2 = freq_odd[1] + freq_even[0];
        
        return Math.min(way1, way2);
    }
    
    public int minOperations(String s) {
        return countFreq(s);
        //return Math.min(countOp(TYPE_0, s), countOp(TYPE_1, s));    
    }
}