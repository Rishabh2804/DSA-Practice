class Solution {
        
    public int[] searchRange(int[] nums, int target) {

        int first = -1, last = -1;
        
        int l = 0; 
        int r = nums.length;
        boolean found = false;
        while(l < r){
            int mid = (l + r) / 2;
            if(nums[mid] == target){
                found = true;
                r = mid;
            }
            else if(nums[mid] > target)
                r = mid;
            else
                l = mid + 1;            
        }
        
        if(found){
            first = l;
        }
        
        l = 0; 
        r = nums.length - 1;        
        while(l < r){
            int mid = (l + r + 1) / 2;
            if(nums[mid] <= target)
                l = mid;
            else
                r = mid - 1;            
        }
        
        if(found)
            last = r;
        
        return new int[]{first, last};        
    }
    
    
}