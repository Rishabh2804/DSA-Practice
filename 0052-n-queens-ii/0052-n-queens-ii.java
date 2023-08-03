class Solution {
    static final int BOARD_SIZE = 10;
    static final boolean[] ROW = new boolean[BOARD_SIZE + 1];
    static final boolean[] COL = new boolean[BOARD_SIZE + 1];
    static final boolean[] POS_DIAG = new boolean[2 * BOARD_SIZE];
    static final boolean[] NEG_DIAG = new boolean[2 * BOARD_SIZE];
    
    private int getNegDiag(int i, int j, int n){
        return (j - i) + (n - 1);
    }
    
    private int getPosDiag(int i, int j, int n){
        // transposing a pos diagonal would give
        // equivalent value of a neg diagonal
        
        // substitute i = n - 1 - i
        // => (j - (n - 1 - i)) + (n - 1)
        // => (j - n + 1 + i) + (n - 1)
        // => (j + i)
        return j + i;
    }
    
    private int solve(int row, int n){
        if(row <= 0) return 1;
        
        int count = 0;
        // Let's keep curr row fixed
        // This is so because, exactly one queen
        // would be present in each row
        //
        // An entire row without a queen would never be 
        // a possible solution        
        for(int col = n; col >= 1; --col){
            int negDiag = getNegDiag(row, col, n);
            int posDiag = getPosDiag(row, col, n);
            
            if(ROW[row] || COL[col] || NEG_DIAG[negDiag] || POS_DIAG[posDiag])
                continue;
            
            // mark visited
            ROW[row] = true;
            COL[col] = true;
            NEG_DIAG[negDiag] = true;
            POS_DIAG[posDiag] = true;
            
            count += solve(row - 1, n);
            
            // reset
            ROW[row] = false;
            COL[col] = false;
            NEG_DIAG[negDiag] = false;
            POS_DIAG[posDiag] = false;            
        }
        
        return count;
    }
    
    public int totalNQueens(int n) {
        if(n == 1) return 1;
        if(n == 2 || n == 3) return 0;
        
        return solve(n, n);
    }
}