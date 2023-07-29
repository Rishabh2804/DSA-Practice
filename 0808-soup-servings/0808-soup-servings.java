class Solution {
    
    static final int[] stateA = {4, 3, 2, 1};
    static final int[] stateB = {0, 1, 2, 3};
    static final double BRANCH_PROB = 0.25;
    
    static boolean initialised = false;
    static final int LIMIT = 200;
    static final double[][] dp = new double[LIMIT + 1][LIMIT + 1];
    
    public double solve(int a, int b, double[][] dp){
        if(a <= 0 && b <= 0) return 0.5; 
        else if(a <= 0) return 1.0;
        else if(b <= 0) return 0.0;
        
        if(dp[a][b] != -1) return dp[a][b];
        
        double prob = 0.0;
        for(int i = 0; i < 4; ++i)
            prob += solve(a - stateA[i], b - stateB[i], dp) * BRANCH_PROB;
        
        return dp[a][b] = prob;
    }
    
    public double soupServings(int n) {        
        n = (n + 25 - 1) / 25; // ceil divide
        if(n >= LIMIT) return 1;
        
        if(!initialised){
            for(double[] row : dp) Arrays.fill(row, -1);            
            initialised = true;
        }
        
        return solve(n, n, dp);
    }
}