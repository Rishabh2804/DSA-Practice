class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        
        PriorityQueue<Integer> row = new PriorityQueue<>((a, b) -> rowSum[b] - rowSum[a]);
        PriorityQueue<Integer> col = new PriorityQueue<>((a, b) -> colSum[b] - colSum[a]);
        
        int n = rowSum.length;
        int m = colSum.length;
        
        for(int i = 0; i < n; ++i) row.add(i);
        for(int i = 0; i < m; ++i) col.add(i);
        
        
        int[][] mat = new int[n][m];
        while(!row.isEmpty() || !col.isEmpty()){
            int currRow = row.poll();
            int currCol = col.poll();
            
            int val = Math.min(rowSum[currRow], colSum[currCol]);            
            mat[currRow][currCol] = val;
            
            rowSum[currRow] -= val;
            colSum[currCol] -= val;
            
            row.add(currRow);
            col.add(currCol);
            
            if(rowSum[row.peek()] == 0 && colSum[col.peek()] == 0) break;
        }
        
        return mat;
    }
    
}


// 0 5 0
// 7 0 0
// 1 1 8