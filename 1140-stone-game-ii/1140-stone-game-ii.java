class Solution {
    
    public int solve(int si, int m, int[] piles, int[][] dp, int[] suffix) {
        if(si >= piles.length) return 0;
        if(dp[si][m] != -1) return dp[si][m];
        
        int maxStones = 0;
        int stones = 0;
        
        int lim = Math.min(2 * m, piles.length - si);
        for(int x = 1; x <= lim; ++x){
            stones += piles[si + x - 1];
            
            int ans = suffix[si + x] - solve(si + x, Math.max(x, m), piles, dp, suffix);
            maxStones = Math.max(maxStones, stones + ans);
        }
        
        return dp[si][m] = maxStones;    
    }
    
    public int stoneGameII(int[] piles) {
        int[][] dp = new int[piles.length][piles.length + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        int[] suffix = new int[piles.length + 1];
        suffix[piles.length - 1] = piles[piles.length - 1];
        
        for(int i = piles.length - 2; i >= 0; --i)
            suffix[i] = piles[i] + suffix[i + 1];
        
        solve(0, 1, piles, dp, suffix);
        
        for(int[] row : dp){
            for(int i : row)
                System.out.print(i + " ");
            System.out.println();
        }
        
//         for(int s : suffix)
//             System.out.print(s + " ");
//         System.out.println();
        
        return dp[0][1];
    }
}