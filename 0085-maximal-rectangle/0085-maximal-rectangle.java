class Solution {
    private static final char ZERO = '0';
    private static final char ONE = '1';
    
    private void print(int[][] mat){
        for(int[] row : mat){
            for(int c : row) System.out.print(c + " ");
            
            System.out.println();
        }
        
        System.out.println();
    }
    
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] horizon = new int[n][m];
        for(int r = 0; r < n; ++r){
            horizon[r][0] = (matrix[r][0] == '1') ? 1 : 0;
            
            for(int c = 1; c < m; ++c){
                if(matrix[r][c] == '1') 
                    horizon[r][c] = 1 + horizon[r][c - 1];
            }
        }
        
        int[][] vertic = new int[n][m];
        for(int c = 0; c < m; ++c){
            vertic[0][c] = (matrix[0][c] == '1') ? 1 : 0;
            
            for(int r = 1; r < n; ++r){
                if(matrix[r][c] == '1') 
                    vertic[r][c] = 1 + vertic[r - 1][c];
            }
        }
        
        int maxArea = 0;
        for(int c = 0; c < m; ++c){
            
            for(int r = n - 1; r >= 0; --r){
                int vLen = vertic[r][c];
                int vStart = r - vLen + 1;
                
                int area = 0;  
                int hLen = horizon[r][c];
                for(int i = r; i >= vStart; --i){
                    hLen = Math.min(hLen, horizon[i][c]);
                    
                    // area = Math.max(area, hLen * (r - i + 1));
                    maxArea = Math.max(maxArea, hLen * (r - i + 1));
                }
            }
        }
        
        
        return maxArea;   
    }
}