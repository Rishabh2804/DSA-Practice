class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] minSum = new int[n][m];
        
        // tabulation
        
        // bottom-right cell
        minSum[n - 1][m - 1] = grid[n - 1][m - 1]; 
        
        // right-most row
        for(int i = n - 2; i >= 0; --i)
            minSum[i][m - 1] = grid[i][m - 1] + minSum[i + 1][m - 1];
        
        // bottom-most column
        for(int j = m - 2; j >= 0; --j)
            minSum[n - 1][j] = grid[n - 1][j] + minSum[n - 1][j + 1];
        
        // remaining grid
        for(int i = n - 2; i >= 0; --i){
            for(int j = m - 2; j >= 0; --j)
                minSum[i][j] = grid[i][j] + Math.min(minSum[i + 1][j], minSum[i][j + 1]);
        }
        
        return minSum[0][0];
    }
    
    // memoization
    public int solve(int i, int j, int[][] grid, int[][] minSum){
        if(i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j];
        
        if(i >= grid.length || j >= grid[0].length)
            return Integer.MAX_VALUE;
        
        if(minSum[i][j] != -1)
            return minSum[i][j];
        
        int path1 = solve(i + 1, j, grid, minSum);
        int path2 = solve(i, j + 1, grid, minSum);
        
        return minSum[i][j] = grid[i][j] + Math.min(path1, path2);
    }
}