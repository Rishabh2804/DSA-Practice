class Solution {
    private int solve(int i, int last, int diff, int[] arr, int[] dp){
        if(i >= arr.length) return 1; 
        
        if(dp[i] != -1) {
            if(arr[i] - last == diff)
                return 1 + dp[i];
        }
        
        dp[i] = solve(i + 1, arr[i], diff, arr, dp);
        
        if(i == 0)
            return dp[i];
        else if(arr[i] - last == diff)
            return 1 + dp[i];
        else
            return solve(i + 1, last, diff, arr, dp);           
    }
    
    public int longestSubsequence(int[] arr, int difference) {
        
        int maxLen = 0;
        HashMap<Integer, Integer> apLen = new HashMap<>();
        for(int i = 0; i < arr.length; ++i){
            int prevTerm = arr[i] - difference;
            int len = 1 + apLen.getOrDefault(prevTerm, 0);
            
            apLen.put(arr[i], len);
            maxLen = Math.max(maxLen, len);
        }
        
        return maxLen;
    }
}