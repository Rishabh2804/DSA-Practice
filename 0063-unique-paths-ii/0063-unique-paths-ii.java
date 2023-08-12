class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {        
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1) 
            return 0;
                
        // tranforming the states in 
        // uppermost row and leftmost column
        // for representing no of paths 
        // - blocked -> 0
        // - open    -> 1        
        int paths = 1;
        for(int i = 0; i < n; ++i){
            // if a single obstacle is found in the path
            // then all following cells would be unreachable
            if(obstacleGrid[i][0] == 1) 
                paths = 0;
            
            obstacleGrid[i][0] = paths;
        }
        
        paths = 1;
        for(int j = 1; j < m; ++j){
            if(obstacleGrid[0][j] == 1) 
                paths = 0;
            
            obstacleGrid[0][j] = paths;
        }
        
        obstacleGrid[0][0] = 1;        
        for(int i = 1; i < n; ++i){
            for(int j = 1; j < m; ++j){                
                if(obstacleGrid[i][j] == 1){
                    // if the cell value is 1 before traversal,
                    // then it must be an obstacle
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                
                obstacleGrid[i][j] += obstacleGrid[i - 1][j]; // up
                obstacleGrid[i][j] += obstacleGrid[i][j - 1]; // left  
                
            }
        }
                
        return obstacleGrid[n - 1][m - 1];
    }
}