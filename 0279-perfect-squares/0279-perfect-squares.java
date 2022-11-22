class Solution {
    public int numSquares(int n) {
        if (isPerfectSquare(n))
            return 1;

        int[] dp = new int[n + 1];        
        for (int i = 1; i <= n; ++i) {
            if (isPerfectSquare(i))
                dp[i] = 1;
            else {       
                dp[i] = 4; // can't be greater than 4
                for (int j = 1; j * j <= i; ++j)
                    dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
            
            // System.out.print(dp[i] + " ");
        }
        
        // System.out.println();
        
        return dp[n];
    }

    public boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);

        return (sqrt * sqrt) == n;
    }
}