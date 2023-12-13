class Solution {
    public int numSpecial(int[][] mat) {
        int count = 0;
        
        int n = mat.length;
        int m = mat[0].length;
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(mat[i][j] == 0) continue;
                
                boolean flag = true;
                for(int i1 = 0; i1 < n; ++i1){
                    if(i1 == i) continue;
                    
                    if(mat[i1][j] == 1) {
                        flag = false;
                        break;
                    }
                }
                
                for(int i1 = 0; i1 < m; ++i1){
                    if(i1 == j) continue;
                    
                    if(mat[i][i1] == 1) {
                        flag = false;
                        break;
                    }
                }
                
                count += (flag) ? 1 : 0;
            }
        }
        
        return count;
    }
}