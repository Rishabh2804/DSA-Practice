class Solution {
    private static final int MOD = 1000000007;
    
    private static final int[][] keyPad = {{1, 2, 3},
                                           {4, 5, 6},
                                           {7, 8, 9},
                                           {-1, 0, -1}};

    private static final int[] xDir = {-2, -2, -1, -1, 1,  1,  2, 2};
    private static final int[] yDir = {-1,  1, -2,  2, 2, -2, -1, 1};
    
    private int getKey(int x, int y){              
        if(x < 1 || x > 3 || y < 1 || y > 4) return -1;
                
        int key = x + 3 * (y - 1);
        if(key > 9) return (key == 11) ? 0 : -1; // 10, 11, 12  --> *, 0, #
        else return key;
    }
    
    private int dial(int x, int y, int n, int[][] dp){ 
        if(n == 0) return 0;
        
        int key = getKey(x, y);
        if(key == -1) return 0;
        
        if(n == 1) return 1;
        
        if(dp[key][n] != -1) return dp[key][n];
        
        int ways = 0;
        for(int dir = 0; dir < 8; ++dir){
            int x1 = x + xDir[dir];
            int y1 = y + yDir[dir];
            
            ways = (ways + dial(x1, y1, n - 1, dp)) % MOD;
        }
        
        return dp[key][n] = ways;
    }
    
    public int knightDialer(int n) {
        int[][] dp = new int[10][n + 1];
        for(int[] key : dp) Arrays.fill(key, -1);
        
        int ways = 0;
        for(int x = 1; x <= 3; ++x){
            for(int y = 1; y <= 3; ++y)
                ways = (ways + dial(x, y, n, dp)) % MOD;
        }
                
        ways = (ways + dial(2, 4, n, dp)) % MOD;        
        return ways;
    }
}