class Solution {
    
    static final int[] xDir = {0, 1, 0, -1};
    static final int[] yDir = {1, 0, -1, 0};
    
    public void convert(int i, int j, int[][] grid, int[][] manDist, Queue<int[]> coords){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        
        if(grid[i][j] != 1) return;
        
        grid[i][j] = 2;
        
        if(manDist[i][j] != 0){
            // if not already added to coords, set manhattan distance to 0
            // and add it to coordinates queue
            manDist[i][j] = 0;
            coords.add(new int[]{i, j});            
        }
        
        for(int dir = 0; dir < 4; ++dir){
            int x = i + xDir[dir];
            int y = j + yDir[dir];
            
            convert(x, y, grid, manDist, coords);
        }        
    }
    
    public int manhattanDist(int i, int j, int[][] grid, int[][] manDist){
        
        Queue<int[]> coords = new LinkedList<>();        
        // convert all 1s of this island to 2
        // and add all coordinates to queue
        convert(i, j, grid, manDist, coords); 
        
        int minDist = Integer.MAX_VALUE;

        while(!coords.isEmpty()){
            int[] curr = coords.poll();
            
            int i1 = curr[0];
            int j1 = curr[1];
                
            for(int dir = 0; dir < 4; ++dir){
                int x = i1 + xDir[dir];
                int y = j1 + yDir[dir];
            
                if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) 
                    continue;
        
                if(manDist[x][y] == -1){                    
                    manDist[x][y] = 1 + manDist[i1][j1];
                    if(grid[x][y] == 1)
                        minDist = Math.min(minDist, manDist[x][y]);
                    
                    coords.add(new int[]{x, y});
                }
            }             
        }
        
        for(int[] row : manDist){
            for(int k : row)
                System.out.print(k + " ");
            System.out.println();
        }
        
        return minDist;
    }
    
    public int shortestBridge(int[][] grid) {
        
        int[][] manDist = new int[grid.length][grid[0].length];
        for(int[] row : manDist)
            Arrays.fill(row, -1);
                
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j] == 1){                    
                    return manhattanDist(i, j, grid, manDist) - 1;                    
                }
            }
        }
        
        return 0;
    }
}

// [[0,1,0,0,0],
//  [0,1,0,1,1],
//  [0,0,0,0,1],
//  [0,0,0,0,0],
//  [0,0,0,0,0]]
 
// 1 0 1 2 3 
// 1 0 1 2 3 
// 2 1 2 3 4 
// 3 2 3 4 5 
// 4 3 4 5 6 
