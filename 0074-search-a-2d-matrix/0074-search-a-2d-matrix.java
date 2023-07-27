class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int si = 0, ei = m * n - 1;
        
        while(si <= ei){
            int mid = (si + ei) / 2;
            int i = mid / m;
            int j = mid % m;
            
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] < target) si = mid + 1;
            else ei = mid - 1;
        }
        
        return false;
    }
}