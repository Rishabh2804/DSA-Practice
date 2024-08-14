class Solution {
    
    private int upperBound(int[] nums, int x){
        int si = 0, ei = nums.length - 1;
        
        while(si < ei){
            int mid = (si + ei + 1) / 2;
            if(nums[mid] > x) ei = mid - 1;
            else si = mid;
        }
        
        return ei;
    }
    
    private int countPairs(int[] nums, int x){
            
        int count = 0;
        for(int i = 0; i < nums.length; ++i){
            int curr_count = upperBound(nums, nums[i] + x);
            count += curr_count - i;
        }
        
        return count;
    }
        
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        int si = 0, ei = 2000000;
        while(si < ei){
            int mid = (si + ei) / 2;
            
            int count = countPairs(nums, mid);
            // if(count == k) return mid;
            // else 
            if(count >= k) ei = mid;
            else si = mid + 1;
        }
        
        return si;
    }
}