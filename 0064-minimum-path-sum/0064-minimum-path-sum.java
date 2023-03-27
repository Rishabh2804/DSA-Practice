class Solution {
    public int minPathSum(int[][] grid) {
        
        int[][] minSum = new int[grid.length][grid[0].length];
        for(int[] row : minSum)
            Arrays.fill(row, -1);
        
        return solve(0, 0, grid, minSum);
    }
    
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