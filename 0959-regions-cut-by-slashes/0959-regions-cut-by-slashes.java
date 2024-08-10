class Solution {
    public int regionsBySlashes(String[] grid) {
        int n=grid.length;
        int mat[][]=new int[n*3][n*3];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i].charAt(j)=='/'){
                    mat[i*3][j*3+2]=1;
                    mat[i*3+1][j*3+1]=1;
                    mat[i*3+2][j*3]=1;
                }else if(grid[i].charAt(j)=='\\'){
                    mat[i*3][j*3]=1;
                    mat[i*3+1][j*3+1]=1;
                    mat[i*3+2][j*3+2]=1;
                }
            }
        }
        int res=0;
        for(int i=0;i<n*3;i++){
            for(int j=0;j<n*3;j++){
                if(dfs(mat,i,j)){
                    res+=1;
                }
            }
        }
        return res;
    }
    public boolean dfs(int[][] dp,int i,int j){
        if(i<0||j<0||i>=dp.length||j>=dp.length||dp[i][j]!=0){
            return false;
        }
        dp[i][j]=-1;
       dfs(dp,i+1,j);
       dfs(dp,i-1,j);
       dfs(dp,i,j+1);
       dfs(dp,i,j-1);
        return true;
    }
}