class Solution {
    public int maxCoins(int[] nums) {
        
        int[] balloons = new int[nums.length + 2];
        balloons[0] = 1;        
        for(int i = 0; i < nums.length; ++i)
            balloons[i + 1] = nums[i];
        balloons[balloons.length - 1] = 1;
        
        int n = balloons.length;
        int maxAns = 0;
        int[][] coins = new int[n][n];                
        for(int i = n - 1; i >= 1; --i){
            for(int j = i + 1; j < n; ++j){
                int temp = Integer.MIN_VALUE;
                for(int k = i; k < j; ++k){
                    int pre = coins[i][k];
                    int post = coins[k + 1][j];
                    temp = Math.max(temp, 
                                  pre + post + 
                                  balloons[i - 1] * balloons[k] * balloons[j]);
                }
                
                coins[i][j] = temp;
            }
        }
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j)
                System.out.print(coins[i][j] + " ");
            System.out.println();
        }
        
        return coins[1][n - 1];
    }
}