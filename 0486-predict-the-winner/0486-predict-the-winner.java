class Solution {
    
    private  int[] sums;
    private  void buildPrefixSum(int[] nums){
        sums = new int[nums.length];
        sums[0] = nums[0];
        
        for(int i = 1; i < nums.length; ++i)
            sums[i] = nums[i] + sums[i - 1];
    }
    
    private  int getRangeSum(int l, int r){
        if(l == 0) return sums[r];
        return sums[r] - sums[l - 1];
    }
    
    public int solve(int si, int ei, int[] nums, int[][] scores){
        if(si == ei) return nums[si];
        
        if(scores[si][ei] != -1) 
            return scores[si][ei];
        
        int rangeSum = getRangeSum(si, ei);
        int left = rangeSum - solve(si + 1, ei, nums, scores);        
        int right = rangeSum - solve(si, ei - 1, nums, scores);
                
        return scores[si][ei] = Math.max(left, right);
    }
    
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length % 2 == 0) return true;
        
        int n = nums.length;
        
        buildPrefixSum(nums); // inititalize prefix sum array
        
        int[][] scores = new int[n][n]; // dp to store max score for player 1 for given range
        for(int[] row : scores)
            Arrays.fill(row, -1);        
        
        int totalScore = getRangeSum(0, n - 1);
        int player1 = solve(0, n - 1, nums, scores);
        int player2 = totalScore - player1;
        
        return player1 >= player2;
    }
}