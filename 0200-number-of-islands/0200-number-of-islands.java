class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for(int i = 0;i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j] == '1'){
                    count ++;
                    dfs(i, j, grid);
                }
            }
        }
        
        return count;
    }
    
    public int[] xDir = {-1, 0, 0, 1};
    public int[] yDir = {0, -1, 1, 0};
    
    public void dfs(int i, int j, char[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return;
        
        if(grid[i][j] == '0')
            return;
        
        grid[i][j] = '0';
        
        for(int dir = 0; dir < 4; ++dir){
            int x = i + yDir[dir];
            int y = j + xDir[dir];
            
            dfs(x, y, grid);            
        } 
    }
}