class Solution {
    
    private static final int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    private int solve(int i, int j, int[][] grid, boolean[][] vis){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;
        
        if(vis[i][j]) return 0;                
        if(grid[i][j] == 0) return 0;
        
        vis[i][j] = true;
        
        int max = 0;
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            
            max = Math.max(max, solve(x, y, grid, vis));
        }
        
        vis[i][j] = false;
        
        return grid[i][j] + max;
    }
    
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        
        int maxGold = 0;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(grid[i][j] != 0) {
                    int currGold = solve(i, j, grid, vis);
                    maxGold = Math.max(maxGold, currGold);
                }
            }
        }
        
        return maxGold;
    }
}