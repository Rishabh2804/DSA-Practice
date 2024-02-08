class Solution {
    
    static final int MAX_SIZE = 101;
    static final int[] SQUARES;
    static final int[] MIN_SQUARES;
    
    static {
        SQUARES = new int[MAX_SIZE];        
        for(int i = 1; i < MAX_SIZE; ++i)
            SQUARES[i] = SQUARES[i - 1] + 2 * i - 1;     
        
        
        MIN_SQUARES = new int[MAX_SIZE * MAX_SIZE];
        for(int i = 1; i < MIN_SQUARES.length; ++i){            
            int minCount = 4;
            for(int j = 1; j < MAX_SIZE; ++j){
                int square = SQUARES[j];
                if(square > i) break;
                
                minCount = Math.min(minCount, 1 + MIN_SQUARES[i - square]);
            }
            
            MIN_SQUARES[i] = minCount;
        }
    }
    
    public int numSquares(int n) {
        return MIN_SQUARES[n];
    }
}