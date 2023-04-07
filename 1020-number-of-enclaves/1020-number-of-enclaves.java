class Solution {
    
    static final int[] xDir = { 1,  0, -1, 0};
    static final int[] yDir = { 0, -1,  0, 1};

    private void dfs(int i, int j, int[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        
        if(grid[i][j] == 0)
            return;
        
        grid[i][j] = 0;
        
        for(int dir = 0; dir < 4; ++dir){
            int x = i + xDir[dir];
            int y = j + yDir[dir];
            
            dfs(x, y, grid);
        }
    }
    
    public int numEnclaves(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i = 0 ; i < n; ++i){
            dfs(i, 0, grid);
            dfs(i, m - 1, grid);
        }
        
        for(int j = 0; j < m; ++j){
            dfs(0, j, grid);
            dfs(n - 1, j, grid);
        }
        
        int count = 0;
        for(int i = 1; i < n - 1; ++i){
            for(int j = 1; j < m - 1; ++j)
                count += grid[i][j];
        }
        
        return count;
    }    
    
}