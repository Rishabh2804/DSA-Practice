class Solution {
   public static void dfs(char [][] board,int row, int col , boolean [][]visited, int [] delr, int [] delc){
       
       if(visited[row][col]) return;
       
        visited[row][col]=true;
        for(int i=0;i<4;i++){
            int r=row+delr[i];
            int c=delc[i]+col;
            if(r>=0&&c>=0&&r<board.length&&c<board[0].length&&board[r][c]=='O'&&visited[r][c]==false){
                dfs(board,r,c,visited,delr,delc);
            }
        }
    }
    
   public static void solve(char[][] board){
    int m=board.length;
    int n=board[0].length;
    int [] delr={-1,0,1,0};
    int [] delc={ 0,1,0,-1};


    boolean[][] visited=new boolean[m][n];
    //for first row and last row
    for(int i=0;i<n;i++){
        if(board[0][i]=='O'&&visited[0][i]==false){
            dfs(board,0,i,visited,delr,delc);
        }
        if(board[m-1][i]=='O'&&visited[m-1][i]==false){
            dfs(board,m-1,i,visited,delr,delc);
        }
    }
    // for first column and last column
    for(int i=0;i<m;i++){
        if(board[i][0]=='O'&&visited[i][0]==false){
            dfs(board,i,0,visited,delr,delc);
        }
        if(board[i][n-1]=='O'&&visited[i][n-1]==false){
            dfs(board,i,n-1,visited,delr,delc);
        }
    }
       
      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            System.out.print(visited[i][j] + " ");
            if(board[i][j]=='O'&&visited[i][j]==false){
                board[i][j]='X';
            }
        }
          System.out.println();
    }
}
}