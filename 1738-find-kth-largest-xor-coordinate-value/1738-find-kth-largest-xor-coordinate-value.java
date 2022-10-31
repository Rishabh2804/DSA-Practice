class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] rowPrefixXor = new int[m][n];
        for(int i = 0; i < m; ++i){
            rowPrefixXor[i][0] = matrix[i][0];
            for(int j = 1; j < n; ++j)
                rowPrefixXor[i][j] = rowPrefixXor[i][j - 1] ^ matrix[i][j];            
        }

        PriorityQueue<Integer> xors = new PriorityQueue<>();

        int[][] gridPrefixXor = new int[m][n];
        for(int j = 0; j < n; ++j) {
            gridPrefixXor[0][j] = rowPrefixXor[0][j];
            xors.add(gridPrefixXor[0][j]);
                
                if(xors.size() > k)
                    xors.poll();
        }
        
        for(int i = 1; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                gridPrefixXor[i][j] = gridPrefixXor[i - 1][j] ^ rowPrefixXor[i][j];
                
                xors.add(gridPrefixXor[i][j]);
                
                if(xors.size() > k)
                    xors.poll();
            }
        }
        
        return xors.poll();
    }
}