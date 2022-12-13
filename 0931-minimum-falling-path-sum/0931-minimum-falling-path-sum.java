class Solution {
    public int minFallingPathSum(int[][] matrix) {    
        int n = matrix.length;
        
        if(n == 1)
            return matrix[0][0];
        
        int[][] pathSum = new int[n][n];
        for(int i = 0; i < n; ++i)
            pathSum[0][i] = matrix[0][i];
        
        for(int i = 1; i < n; ++i){
            
            pathSum[i][0] = matrix[i][0] + 
                            Math.min(pathSum[i - 1][0], pathSum[i - 1][1]);
            
            for(int j = 1; j < n - 1; ++j)
                pathSum[i][j] = matrix[i][j] + 
                                Math.min(pathSum[i - 1][j],                                                         Math.min(pathSum[i - 1][j - 1], pathSum[i - 1][j + 1]));
            
            pathSum[i][n - 1] = matrix[i][n - 1] + 
                                Math.min(pathSum[i - 1][n - 2], pathSum[i - 1][n - 1]);
            
        }
        
        int minPathSum = Integer.MAX_VALUE;
        for(int i = 0; i < n; ++i)
            minPathSum = Math.min(minPathSum, pathSum[n - 1][i]);
        
        return minPathSum;
    }
}