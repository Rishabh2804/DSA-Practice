class Solution {
    
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