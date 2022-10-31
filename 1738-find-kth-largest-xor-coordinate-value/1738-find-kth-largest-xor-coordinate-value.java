class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        PriorityQueue<Integer> xors = new PriorityQueue<>();

        int[][] gridPrefixXor = new int[m][n];
        gridPrefixXor[0][0] = matrix[0][0];
        xors.add(gridPrefixXor[0][0]);
        
        for(int i = 1; i < m; ++i){
            gridPrefixXor[i][0] = gridPrefixXor[i - 1][0] ^ matrix[i][0];
            
            xors.add(gridPrefixXor[i][0]);
                
            if(xors.size() > k)
                xors.poll();
        }
        
        for(int j = 1; j < n; ++j){
            gridPrefixXor[0][j] = gridPrefixXor[0][j - 1] ^ matrix[0][j];
            
            xors.add(gridPrefixXor[0][j]);
                
            if(xors.size() > k)
                xors.poll();
        }    
        
        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                gridPrefixXor[i][j] = gridPrefixXor[i - 1][j] 
                                      ^ gridPrefixXor[i][j - 1]
                                      ^ gridPrefixXor[i - 1][j - 1]
                                      ^ matrix[i][j];
                
                xors.add(gridPrefixXor[i][j]);
                
                if(xors.size() > k)
                    xors.poll();
            }
        }
        
        return xors.poll();
    }
}