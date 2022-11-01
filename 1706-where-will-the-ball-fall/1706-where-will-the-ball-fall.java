class Solution {
    public int[] findBall(int[][] grid) {
        
        int[] ans = new int[grid[0].length];
        for(int i = 0; i < grid[0].length; ++i){
            ans[i] = path(0, i, grid);
        }
        
        return ans;
    }
    
    public int path(int i, int j, int[][] grid){
        if(j < 0 || j >= grid[0].length)
            return -1;
        
        if(i >= grid.length)
            return j;
        
        // backslash (\)
        if(grid[i][j] == 1) {
            if(j == grid[0].length - 1 || grid[i][j + 1] == -1) // stuck condition
                return -1;
            else
                return path(i + 1, j + 1, grid);
        }
        else{ // forward slash(/)
            if(j == 0 || grid[i][j - 1] == 1) // stuck condition
                return -1;
            else
                return path(i + 1, j - 1, grid);
        }            
    }
}