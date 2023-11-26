class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        // int[] rowSum = new int[n];
        for(int i = 1; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(matrix[i][j] == 0) continue;
                
                matrix[i][j] += matrix[i - 1][j];
            }
                        
        }
        
        int maxArea = 0;
        for(int[] row : matrix){
            Arrays.sort(row);
            
            for(int j = 0; j < m; ++j)
                maxArea = Math.max(maxArea, row[j] * (m - j));
        }
        
        return maxArea;        
    }
}