class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int[] sum = new int[n];
        
        sum[0] = s.charAt(0) - '0';
        for(int i = 1; i < n; ++i)
            sum[i] = sum[i - 1] + s.charAt(i) - '0';
        
        int maxScore = 0;
        
        for(int i = 1; i < n; ++i){
            int left = i - sum[i - 1];
            int right = sum[n - 1] - sum[i - 1];
            
            maxScore = Math.max(maxScore, left + right);
        }
        
        return maxScore;
    }
}