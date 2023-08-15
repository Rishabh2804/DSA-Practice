class Solution {
    
    static final int MAX_SIZE = 10;
    
    static final char QUEEN = 'Q';
    static final char EMPTY = '.';
    
    // gallery -> row
    // rank    -> column
    static final boolean[] col   = new boolean[MAX_SIZE];
    static final boolean[] diag1 = new boolean[2 * MAX_SIZE - 1];
    static final boolean[] diag2 = new boolean[2 * MAX_SIZE - 1];

    List<List<String>> configs;
    
    private void solve(int gallery, int n, List<Integer> colIdx){
        if(gallery >= n) {
            List<String> currConfig = new ArrayList<>();
            for(int r = 0; r < n; ++r){
                String currRow = "";
                int queenPos = colIdx.get(r);
                for(int col = 0; col < queenPos; ++col)
                    currRow += EMPTY;
                
                currRow += QUEEN;
                
                for(int col = queenPos + 1; col < n; ++col)
                    currRow += EMPTY;
                
                currConfig.add(currRow);
            }    
            
            configs.add(currConfig);
            return;
        }
        
        for(int rank = 0; rank < n; ++rank){
            int leftDiag = gallery + rank;
            int rightDiag = gallery - rank + n - 1;
            if(col[rank] || diag1[leftDiag] || diag2[rightDiag]) continue;
            
            col[rank] = true;
            diag1[leftDiag] = true;
            diag2[rightDiag] = true;
            
            colIdx.add(rank);
            
            solve(gallery + 1, n, colIdx);
            
            colIdx.remove(colIdx.size() - 1);
            
            col[rank] = false;
            diag1[leftDiag] = false;
            diag2[rightDiag] = false;            
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        configs = new ArrayList<>();
        if(n == 1) {
            configs.add(new ArrayList<>());
            configs.get(0).add("Q");
            return configs;
        }
        
        if(n == 2 || n == 3) return configs;
        solve(0, n, new ArrayList<>());
        
        return configs;
    }
    
    
}