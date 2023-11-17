class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        
        int[] preSum = new int[n];
        int[] suffSum = new int[n];
        
        preSum[0] = cardPoints[0];
        for(int i = 1; i < n; ++i)
            preSum[i] = cardPoints[i] + preSum[i - 1];
        
        suffSum[n - 1] = cardPoints[n - 1];
        for(int i = n - 2; i >= 0; --i)
            suffSum[i] = cardPoints[i] + suffSum[i + 1];
        
        int maxScore = suffSum[n - k];
        for(int i = 0; i < k - 1; ++i)
            maxScore = Math.max(maxScore, preSum[i] + suffSum[n - (k - i) + 1]);
        
        maxScore = Math.max(maxScore, preSum[k - 1]);
        
        return maxScore;
    }
}