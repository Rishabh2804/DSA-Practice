class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int i = n - 2; i >= 0; --i){
            for(int j = 0; j < m; ++j){
                
                int minSum = Integer.MAX_VALUE;
                if(j > 0) minSum = Math.min(minSum, matrix[i + 1][j - 1]);
                
                minSum = Math.min(minSum, matrix[i + 1][j]);
                
                if(j < m - 1) minSum = Math.min(minSum, matrix[i + 1][j + 1]);
                
                matrix[i][j] += minSum;
            }
        }
        
        int minFallSum = Integer.MAX_VALUE;
        for(int i : matrix[0])
            minFallSum = Math.min(minFallSum, i);
        
        return minFallSum;
    }
}