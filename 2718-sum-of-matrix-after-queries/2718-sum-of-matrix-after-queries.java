class Solution {
    static final int TYP = 0;
    static final int IDX = 1;
    static final int VAL = 2;
    
    static final int TYP_ROW = 0;
    static final int TYP_COL = 1;
    
    public long matrixSumQueries(int n, int[][] queries) {
        long totalSum = 0;
        
        int rowsUpdated = 0; // no of distinct rows updated
        int colsUpdated = 0; // no of distinct cols updated
        
        boolean[] rowReg = new boolean[n]; // register for checking occupance of ith row
        boolean[] colReg = new boolean[n]; // register for checking occupance of ith row
        
        // each query can be thought of a strip of
        // values, to be pasted on a square paper.
        // a strip pasted later would hide the strips below it,
        // thus totalSum = totalSum + (n * currValue) - (overlapping strips)
        
        // we will start from last query,
        // as the last strip would be wholly visible.
        // progressing backwards, a strip's sum is added after 
        // excluding portion of it which would be overlapped by later strips
        for(int q = queries.length - 1; q >= 0; --q){
            int type = queries[q][TYP];
            int idx = queries[q][IDX];
            int val = queries[q][VAL];
            
            if(type == TYP_ROW){
                // if curr row is already wholly occupied by another strip
                // then this strip would anyways be hidden.
                if(rowReg[idx]) continue;
                rowsUpdated++;
                
                rowReg[idx] = true; // occupy curr row
                totalSum += 1L * val * (n - colsUpdated); 
            } else if(type == TYP_COL){
                // if curr col is already wholly occupied by another strip
                // then this strip would anyways be hidden.
                if(colReg[idx]) continue;
                
                colReg[idx] = true; // occupy curr col
                colsUpdated++;

                totalSum += 1L * val * (n - rowsUpdated);   
            }
        }
        
        return totalSum;        
    }
}