class Solution {
    
    private static final int NONE = -1;   
    private static final int DEF_LEN = 1;
    private static final int MIN_LEN = 2;
    private static final int MAX = 46341; // sqrt of Integer.MAX_VALUE
    
    private int solve(int curr, HashMap<Integer, Integer> dp){
        if(!dp.containsKey(curr)) return 0;
        
        if(dp.get(curr) > DEF_LEN) return dp.get(curr);
        
        int len = 1 + solve(curr * curr, dp);
        dp.put(curr, len);
        
        return len;
    }
    
    public int longestSquareStreak(int[] nums) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        for(int i : nums) dp.put(i, DEF_LEN);
        
        int maxLen = DEF_LEN;
        for(int num : dp.keySet()){
            if(num > MAX) continue;
            
            int len = solve(num, dp);
            maxLen = Math.max(maxLen, len);
        }
        
        if(maxLen < MIN_LEN) return NONE;
        return maxLen;
    }
}