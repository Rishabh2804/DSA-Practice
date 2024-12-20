class Solution {
    
    private static final int NONE = -1;   
    private static final int DEF_LEN = 1;
    private static final int MIN_LEN = 2;
    private static final int MAX = 46341; // sqrt of Integer.MAX_VALUE
    
    private void print(int[] arr){
        for(int i : arr)
            System.out.print(i + " ");
        
        System.out.println();
    }
    
    private int lowerBound(int x, int si, int[] arr){
        
        int ei = arr.length - 1;
        while(si < ei){
            
            int mid = (si + ei) / 2;
            if(arr[mid] >= x) ei = mid;
            else si = mid + 1;
        }
        
        if(si >= arr.length || arr[si] != x) return NONE;
        return si;
    }
    
    private int solve(int i, int[] nums, int[] dp){
        if(i >= nums.length) return DEF_LEN;
        
        if(dp[i] != DEF_LEN) return dp[i];
        
        int curr = nums[i];
        if(curr > MAX) return DEF_LEN;
        
        int next = lowerBound(curr * curr, i, nums);
        if(next == NONE) return DEF_LEN;
        
        return dp[i] = 1 + solve(next, nums, dp);
    }
    
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, DEF_LEN);
        
        int max = DEF_LEN;
        for(int i = 0; i < nums.length; ++i){
            int currLen = solve(i, nums, dp);
            max = Math.max(max, currLen);
        }
        
        if(max < MIN_LEN) return NONE;
        return max;
    }
}