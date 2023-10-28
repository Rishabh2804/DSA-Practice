class Solution {
    int mod = 1000000007;
    
    public int modularise(int a, int b){
        return ((a % mod) + (b % mod)) % mod;
    }
    
    public int countVowelPermutation(int n) {
        int[][] ways = new int[n + 1][5];
        ways[1][0] = 1;
        ways[1][1] = 1;
        ways[1][2] = 1;
        ways[1][3] = 1;
        ways[1][4] = 1;
        
        for(int i = 2; i <= n; ++i){
            ways[i][0] = modularise(modularise(ways[i - 1][1], ways[i - 1][2]), 
                                    ways[i - 1][4]);                   // e, i, u
            ways[i][1] = modularise(ways[i - 1][0], ways[i - 1][2]);   // a, i
            ways[i][2] = modularise(ways[i - 1][1], ways[i - 1][3]);   // e, o
            ways[i][3] = ways[i - 1][2] % mod;                         // i
            ways[i][4] = modularise(ways[i - 1][2], ways[i - 1][3]);   // i, o         
        }
        
        int ans = 0;
        for(int way : ways[n])
            ans = modularise(ans, way);
        
        return ans;            
    }
}

// 