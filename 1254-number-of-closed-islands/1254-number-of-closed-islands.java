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
            if(grid[i][0] == TYPE_ISLAND) dfs(i, 0, grid);
        }
        
        for(int i = 0; i < n; ++i){
            if(grid[i][m - 1] == TYPE_ISLAND) dfs(i, m - 1, grid);
        }
        
        for(int j = 0; j < m; ++j){
            if(grid[0][j] == TYPE_ISLAND) dfs(0, j, grid);
        }
        
        for(int j = 0; j < m; ++j){
            if(grid[n - 1][j] == TYPE_ISLAND) dfs(n - 1, j, grid);
        }
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                count += (grid[i][j] == TYPE_ISLAND) ? 1 : 0;   
                dfs(i, j, grid);
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
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