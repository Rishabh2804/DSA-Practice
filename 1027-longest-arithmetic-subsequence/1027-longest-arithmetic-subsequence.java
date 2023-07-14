class Solution {
    static final int MAX_DIFF = 502;
    static final int NULL_VAL = MAX_DIFF - 1;
    
    public int solve(int i, int d, int lastIdx, int[] nums, int[][] dp){
        if(i >= nums.length) return 0;
        
        if(dp[i][lastIdx] != -1) return dp[i][lastIdx];

        // we always have the provision to start a new AP from ith element
        int take_new = solve(i + 1, NULL_VAL, i, nums, dp);

        int leave = 0;
        int take_forward = 0;
        
        // if the current element fits into ongoing AP, 
        // then there is no point in leaving it

        // * <d != NULL_VAL> condition gets checked automatically
        if(lastIdx != NULL_VAL && nums[i] - nums[lastIdx] == d) 
            take_forward = solve(i + 1, d, i, nums, dp);
        else 
            leave = solve(i + 1, d, lastIdx, nums, dp);
        
        return dp[i][lastIdx] = Math.max(leave, 1 + Math.max(take_forward, take_new));        
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
    
    public int longestArithSeqLength(int[] nums) {
        int maxLen = 0;
        for(int diff = -500; diff <= 500; ++diff){
            int len = longestSubsequence(nums, diff);
            maxLen = Math.max(maxLen, len);
        }
        
        return maxLen;
    }
}