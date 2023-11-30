class Solution {
    
    private int[] copyRange(int l, int r, int[] nums){
        int n = r - l + 1;
        int[] arr = new int[n];
        
        for(int i = 0; i < n; ++i)
            arr[i] = nums[l + i];
        
        return arr;
    }
    
    private boolean checkAP(int l, int r, int[] nums){    
        int n = r - l + 1;
        if(n <= 2) return true;
        
        int[] arr = copyRange(l, r, nums);
        
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        for(int i = 2; i < n; ++i){
            if(arr[i] - arr[i - 1] != d) return false;
        }
        
        return true;
    }
    
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int q = l.length;
        
        List<Boolean> res = new ArrayList<>();
        for(int i = 0; i < q; ++i)
            res.add(checkAP(l[i], r[i], nums));
        
        return res;
    }
}