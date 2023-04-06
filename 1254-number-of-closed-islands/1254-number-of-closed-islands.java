class Solution {
    
    static final int[] xDirs = { 1,  0, -1, 0};
    static final int[] yDirs = { 0, -1,  0, 1};
    
    static final int TYPE_ISLAND = 0;
    static final int TYPE_WATER = 1;
    static final int TYPE_SHORE = 2;
    
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int count = 0;
        
        for(int i = 0; i < n; ++i){
            dfs(i, 0, grid);
            dfs(i, m - 1, grid);
        }
        
        for(int j = 0; j < m; ++j){
            dfs(0, j, grid);
            dfs(n - 1, j, grid);
        }
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if(grid[i][j] == TYPE_ISLAND){
                    count ++;
                    dfs(i, j, grid);
                }
            }
        }
        
        return count;
    }
    
    public void dfs(int i, int j, int[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        
        if(grid[i][j] == TYPE_WATER || grid[i][j] == TYPE_SHORE)
            return;
        
        grid[i][j] = TYPE_SHORE;
        for(int dir = 0; dir < 4; ++dir){
            int x = i + xDirs[dir];
            int y = j + yDirs[dir];
            
            dfs(x, y, grid);
        }        
    }
}