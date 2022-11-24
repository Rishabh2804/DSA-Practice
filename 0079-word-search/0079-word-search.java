class Solution {
    
    char[] word;
    
    public boolean exist(char[][] board, String word) {
        this.word = word.toCharArray();
        
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(dfs(i, j, board, visited, 0))
                    return true;
            }
        }
        
        return false;
    }
    
    int[] xDir = {-1, 0, 1, 0};
    int[] yDir = {0, 1, 0, -1};
    
    public boolean dfs(int i, int j, char[][] board, boolean[][] visited, int k){
        if(k >= word.length)
            return true;
        
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;        
        
        if(visited[i][j] || board[i][j] != word[k])
            return false;
            
        visited[i][j] = true;
        for(int dir = 0; dir < 4; ++dir){
            int x = i + xDir[dir];
            int y = j + yDir[dir];
            
            if(dfs(x, y, board, visited, k + 1))
                return true;
        }
            
        return visited[i][j] = false;
    }
}