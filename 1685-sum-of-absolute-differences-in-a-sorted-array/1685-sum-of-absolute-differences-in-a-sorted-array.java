class Solution {
        
    private int[] sum;
    
    private void initSum(int[] nums){
        int n = nums.length;
        
        sum = new int[n];
        sum[0] = nums[0];
        for(int i = 1; i < n; ++i)
            sum[i] = nums[i] + sum[i - 1];        
    }
    
    private int getSum(int l, int r){
        if(l == 0) return sum[r];
        else return sum[r] - sum[l - 1];
    }
    
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        
        initSum(nums);
        
        int[] abSum = new int[n];
        for(int i = 0; i < n; ++i){
            int seg1Len = i + 1;
            int seg1Sum = (nums[i] * seg1Len) - getSum(0, i);
            
            int seg2Len = n - i - 1;
            int seg2Sum = getSum(i + 1, n - 1) - (nums[i] * seg2Len);
            
            abSum[i] = seg1Sum + seg2Sum;
        }
        
        return abSum;
    }
}