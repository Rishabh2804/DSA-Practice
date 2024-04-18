class Solution {
    
    private static final int VIS = -1;
    private static final int WATER = 0;
    private static final int LAND = 1;

    private static final int[][] dirs = {
        {-1, 0}, {0, -1}, {1, 0}, {0, 1}
    };
    
    private int countBoundary(int i, int j, int[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 1;
        
        if(grid[i][j] == VIS) return 0;
        else if(grid[i][j] == WATER) return 1;
        
        grid[i][j] = VIS;
        
        int count = 0;
        for(int[] dir : dirs){
            int x = dir[0] + i;
            int y = dir[1] + j;
            
            count += countBoundary(x, y, grid);
        }
        
        return count;
    }
        
    public int islandPerimeter(int[][] grid) {
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j] == LAND) return countBoundary(i, j, grid);
            }
        }
        
        return 0;
    }
}