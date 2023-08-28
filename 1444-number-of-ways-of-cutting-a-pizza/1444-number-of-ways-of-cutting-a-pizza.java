class Solution {
    
    static final int MOD = 1000000007;
    
    static int[][] apples;
    private int getApples(int r, int c){
        if(r == 0)
            return apples[apples.length - 1][c];
        else return apples[apples.length - 1][c] - apples[r - 1][c];
    }
    
    public int solve(int r, int c, int k, Integer[][][] dp){
        if(k == 1) return 1;
        
        if(dp[r][c][k] != null) return dp[r][c][k];
        
        int rows = dp.length;
        int cols = dp[0].length;
        
        int totalApples = getApples(r, c);
        
        int ans = 0;
        for(int i = r + 1; i < rows; ++i){
            int apples1 = getApples(i, c);
            int apples2 = totalApples - apples1;
            
            if(apples1 == 0 || apples2 == 0) continue;
            
            ans = ((ans % MOD) + (solve(i, c, k - 1, dp) % MOD)) % MOD;
        }
        
        for(int i = c + 1; i < cols; ++i){
            int apples1 = getApples(r, i);
            int apples2 = totalApples - apples1;
            
            if(apples1 == 0 || apples2 == 0) continue;
            
            ans = ((ans % MOD) + (solve(r, i, k - 1, dp) % MOD)) % MOD;
        }
        
        return dp[r][c][k] = ans;
    }
    public int ways(String[] pizza, int k) {
        int rows = pizza.length;
        int cols = pizza[0].length();
                
        apples = new int[rows][cols];
        apples[0][cols - 1] = (pizza[0].charAt(cols - 1) == 'A') ? 1 : 0;
        
        for(int col = cols - 2; col >= 0; --col){
            apples[0][col] = apples[0][col + 1];
            if(pizza[0].charAt(col) == 'A')
                apples[0][col]++;
        }
        
        for(int row = 1; row < rows; ++row){
            apples[row][cols - 1] = apples[row - 1][cols - 1];
            if(pizza[row].charAt(cols - 1) == 'A')
                apples[row][cols - 1]++;
        }
        
        for(int row = 1; row < rows; ++row){
            for(int col = cols - 2; col >= 0; --col){
                // inclusion - exclusion principle
                apples[row][col] = apples[row][col + 1] + apples[row - 1][col] - apples[row - 1][col + 1];
                if(pizza[row].charAt(col) == 'A')
                    apples[row][col]++;                                
            }
        }
                
        if(k == 1){
            if(apples[rows - 1][0] > 0) return 1;
            else return 0;
        }
        
        for(int[] row : apples){
            for(int apple : row)
                System.out.print(apple + " ");
            System.out.println();
        }
        
        Integer[][][] dp = new Integer[rows][cols][k + 1];
        return solve(0, 0, k, dp);
    }
}