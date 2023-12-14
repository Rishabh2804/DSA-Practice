class Solution {
    
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[] diffRow = new int[n];
        int[] diffCol = new int[m];
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                int val = -1 + 2 * grid[i][j];
                
                diffRow[i] += val;
                diffCol[j] += val;
            }
        }
        
        int[][] diff = new int[n][m];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j)
                diff[i][j] = diffRow[i] + diffCol[j];
        }
        
        return diff;
    }
}