class Solution {
    
    static final int[] xDir = {-1,  0, 1, 0};
    static final int[] yDir = { 0, -1, 0, 1};

    private void dfs(int i, int j, int dist, int[][] map, int[][] mat){
        if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length)
            return;
        
        if(map[i][j] <= dist)
            return;
        
        if(mat[i][j] == 0)
            map[i][j] = 0;            
        else map[i][j] = 1 + dist;
        
        for(int dir = 0; dir < 4; ++dir){
            int x = xDir[dir];
            int y = yDir[dir];
            
            dfs(i + x, j + y, map[i][j], map, mat);
        }                    
    }
    
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] map = new int[n][m];
        
        for(int[] row : map)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(mat[i][j] == 0){
                    dfs(i, j, 0, map, mat);
                    break;
                }
            }                
        }
        
        return map;
    }
}