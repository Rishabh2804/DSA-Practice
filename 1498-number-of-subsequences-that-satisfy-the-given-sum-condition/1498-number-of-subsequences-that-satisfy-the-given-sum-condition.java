class Solution {
    static final int mod = 1000000007;

    public int upperBound(int[] arr, int l, int r, int target){        
        while(l < r) {
            int mid = (l + r + 1) / 2;
            if(arr[mid] > target)
                r = mid - 1;
            else
                l = mid;
        }
        
        if(arr[r] <= target)
            return r;
        else
            return -1;
    }
    
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);        
        
        int[] power = new int[n + 1];
        power[0] = 1;
        for(int i = 1; i <= n; ++i)
            power[i] = (power[i - 1] * 2) % mod;
        
        long count = 0;
        int l = 0, r = nums.length - 1;
        while(l <= r){            
            int max = target - nums[r];
            int idx = upperBound(nums, l, r, max);
            if(idx < l){
                r--;
                continue;
            }
            
            int len1 = idx - l + 1;
            int len2 = r - idx;
            
            long ans1 = power[len1] - 1;
            long ans2 = power[len2];
            
            count += ((power[len1] - 1L) * power[len2]) % mod;
            
            l = idx + 1;
            r--;
        }
        
        return (int)(count % mod);
    }
}