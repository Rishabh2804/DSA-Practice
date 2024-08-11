class Solution {
    private void dfs(int grid[][], int r, int c, boolean check[][]){
        int row[]={1,-1,0,0};
        int col[]={0,0,1,-1};
        check[r][c]=true;
        int temp=0;
        for(int i=0;i<4;i++){
            int tr=r+row[i];
            int tc=c+col[i];
            if(tr>=0 && tc>=0 && tr<grid.length && tc<grid[0].length && grid[tr][tc]==1 && !check[tr][tc]){
                dfs(grid,tr,tc,check);
            }
        }
    }
    private int cisland(int grid[][], int m, int n){
        int count=0;
        boolean check[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !check[i][j]){
                    dfs(grid,i,j,check);
                    count++;
                }
            }
        }
        return count;
    }
    public int minDays(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(cisland(grid,m,n)!=1){
            return 0;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    if(cisland(grid,m,n)!=1)
                        return 1;
                    grid[i][j]=1;
                }
            }
        }
        return 2;
    }
}