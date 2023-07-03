class Solution {
    public int[] getAverages(int[] nums, int k) {
        int winLen = 2 * k + 1;
        
        int[] avg = new int[nums.length];
        Arrays.fill(avg, -1);
        
        long sum = 0;
        for(int i = 0; i < Math.min(winLen - 1, nums.length); ++i)
            sum += nums[i];
        
        for(int i = k; i < nums.length - k; ++i){
            sum += nums[i + k];
            
            avg[i] = (int)(sum / winLen);
            
            sum -= nums[i - k];
        }
        
        return avg;
    }
}