class Solution {
    
    private long[] sum;
    
    private void initSum(int[] nums){
        int n = nums.length;
        sum = new long[n];
        
        sum[0] = nums[0];
        for(int i = 1; i < n; ++i)
            sum[i] = sum[i - 1] + nums[i];        
    }
    
    private long getSum(int l, int r){
        if(l == 0) return sum[r];
        else return sum[r] - sum[l - 1];
    }
    
    private void print(long[] nums){
        for(var i : nums)
            System.out.print(i + " ");
        
        System.out.println();        
    }
    
    private int getNextIdx(int si, int[] nums){
        int curr = nums[si];
        int ei = nums.length;
        
        while(si < ei){
            int mid = (si + ei) / 2;
            
            if(nums[mid] > curr) ei = mid;
            else si = mid + 1;
        }
        
        return si;
    }
    
    private int getMoreFreq(int i, int k, int[] nums){
        if(i == 0) return 0;
        
        int curr = nums[i];
        int si = 0;
        int ei = i;
        
        while(si < ei){
            int mid = (si + ei) / 2;
            
            long currSum = getSum(mid, i - 1);
            long reqSum = 1l * curr * (i - mid);
            long reqOp = reqSum - currSum;
            
            if(reqOp <= k) ei = mid;
            else si = mid + 1;
        }
        
        return i - si;
    }
    
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        
        initSum(nums);
        
        int maxFreq = 0;
        int i = 0;
        while(i < n){
            int nextIdx = getNextIdx(i, nums);
            
            int currFreq = nextIdx - i;
            
            currFreq += getMoreFreq(i, k, nums);
            maxFreq = Math.max(maxFreq, currFreq);
            
            i = nextIdx;
        }
        
        return maxFreq;
    }
}