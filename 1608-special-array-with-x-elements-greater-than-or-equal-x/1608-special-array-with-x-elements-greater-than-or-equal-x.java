class Solution {
    
    private int lowerBound(int[] arr, int x){
        
        int si = 0, ei = arr.length - 1;
        while(si < ei){
            int mid = (si + ei) / 2;
            
            if(arr[mid] < x) si = mid + 1;
            else ei = mid;
        }
        
        return si;        
    }
    
    
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        
        int max = 0;
        for(int i = 0; i < nums.length; ++i) max = Math.max(max, nums[i]);
        
        int si = 0, ei = max;
        while(si <= ei){
            int mid = si;
            
            int pos = lowerBound(nums, mid);
            int grt = nums.length - pos;
            
            if(mid == grt) return mid;
            
            si ++;
        }
        
        return -1;
    }
}

// 0 0 3 4 4

// 0 0 1 4 6 9