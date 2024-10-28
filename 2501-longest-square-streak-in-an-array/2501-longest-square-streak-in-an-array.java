class Solution {
    private static final int NONE = -1;
    private static final int MIN_LEN = 2;
    
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
    
    private int solve(int i, int[] nums){
        if(i >= nums.length) return 0;
        
        int curr = nums[i];
        int next = lowerBound(curr * curr, i, nums);
        if(next == NONE) return 1;
        
        return 1 + solve(next, nums);
    }
    
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        
        int max = 0;
        for(int i = 0; i < nums.length; ++i){
            int currLen = solve(i, nums);
            max = Math.max(max, currLen);
        }
        
        if(max < MIN_LEN) return NONE;
        return max;
    }
}