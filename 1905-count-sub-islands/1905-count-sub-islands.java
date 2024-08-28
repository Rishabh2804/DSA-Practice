class Solution {
    
    private void traverse(int i, int j, int[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        
        if(grid[i][j] == 0) return;
        
        grid[i][j] = 0;
        
        traverse(i + 1, j, grid);
        traverse(i, j + 1, grid);
        traverse(i - 1, j, grid);
        traverse(i, j - 1, grid);        
    }
    
    private int countIslands(int[][] grid){
        
        int count = 0;
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j] == 0) continue;
                
                count ++;
                traverse(i, j, grid);
            }
        }
        
        return count;
    }
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        for(int i = 0; i < grid1.length; ++i){
            for(int j = 0; j < grid1[0].length; ++j){
                if(grid1[i][j] == 0) traverse(i, j, grid2);                
            }
        }
        
        return countIslands(grid2);        
    }
}