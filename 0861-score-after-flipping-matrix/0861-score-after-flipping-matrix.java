class Solution {
    
    private int[] col;
    
    private int parse(int[] num){
        int val = 0;
        for(int i = 0; i < num.length; ++i){
            val *= 2;
            val += num[i];
        }
        
        return val;
    }
    
    private int getScore(int[][] grid){
        int score = 0;
        for(int[] row : grid) score += parse(row);
        
        return score;
    }
    
    private void print(int[][] grid){
        for(int[] row : grid){
            for(int c : row)
                System.out.print(c + " ");
            System.out.println();
        }
        
        System.out.println();
    }
    
    private void flipH(int r, int[][] grid){
        for(int i = 0; i < grid[r].length; ++i){            
            if(grid[r][i] == 1) {
                grid[r][i] = 0;
                col[i]--;
            } else {
                grid[r][i] = 1;
                col[i]++;
            }            
        }
    }
    
    private void flipV(int c, int[][] grid){        
        col[c] = grid.length - col[c];
        
        for(int i = 0; i < grid.length; ++i)
            grid[i][c] = 1 - grid[i][c];
    }
    
    private boolean checkCols(int[][] grid){
        boolean ok = true;
        
        int n = grid.length;
        for(int i = 0; i < grid[0].length; ++i){
            int on = col[i];
            int off = n - col[i];
            
            if(off > on) {
                flipV(i, grid);
                ok = false;
            }
        }
        
        return ok;
    }
    
    private boolean checkRows(int[][] grid){
        boolean ok = true;
        
        int n = grid.length;
        for(int i = 0; i < n; ++i){
            if(grid[i][0] == 0) {
                flipH(i, grid);
                ok = false;
            }
        }
        
        return ok;
    }
    
    public int matrixScore(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        col = new int[m];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j)
                col[j] += grid[i][j];
        }
        
        boolean done = false;
        while(!done){
            boolean op1 = checkCols(grid);
            boolean op2 = checkRows(grid);
            done = op1 && op2;
        }
        
        return getScore(grid);
    }
}

// 1111
// 1001
// 1111

// 01
// 11