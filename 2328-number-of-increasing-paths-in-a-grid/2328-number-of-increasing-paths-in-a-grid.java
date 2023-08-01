class Solution {
    static final int MOD = 1000000007;
    
    static final int VAL = 0;
    static final int X = 1;
    static final int Y = 2;
    
    static final int[] xDir = {0, 1, 0, -1};
    static final int[] yDir = {-1, 0, 1, 0};
    
    private int ADD(int a, int b){
        return ((a % MOD) + (b % MOD)) % MOD;
    }
    
    public int countPaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // sorting cells on basis of values
        PriorityQueue<int[]> cells = new PriorityQueue<>((a, b) -> b[VAL] - a[VAL]);        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j)
                cells.add(new int[]{grid[i][j], i, j});            
        }
        
        int[][] paths = new int[n][m];
        for(int[] row : paths)
            Arrays.fill(row, 1);
        
        while(!cells.isEmpty()){
            int[] cell = cells.poll();
            int val = cell[0];
            int i = cell[1];
            int j = cell[2];
            
            for(int dir = 0; dir < 4; ++dir){
                int x = i + xDir[dir];
                int y = j + yDir[dir];

                // out of bound
                if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) continue;

                // the cell values greater than current cell would
                // have been calculated already
                if(grid[x][y] > val) // strictly increasing path only 
                    paths[i][j] = ADD(paths[i][j], paths[x][y]);
            }
        }
        
        int totalPaths = 0;
        for(int[] row : paths){
            for(int path : row) totalPaths = ADD(totalPaths, path);
        }
        
        return totalPaths;
    }
}