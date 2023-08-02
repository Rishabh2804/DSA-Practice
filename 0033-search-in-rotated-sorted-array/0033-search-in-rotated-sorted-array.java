class Solution {
    
    private int getMaxIdx(int lsi, int lei, int rsi, int rei, int[] nums){
        
        // left subarr is exhausted 
        if(lsi > lei) {             
            // the max size of right subarray would be 2
            // can be done by a linear search
            
            int maxIdx = rsi;
            for(int i = rsi; i <= rei; ++i){
                if(nums[i] > nums[maxIdx])
                    maxIdx = i;
            }
            
            return maxIdx;
        }
        
        // right subarr is exhausted 
        if(rsi > rei) {             
            // the max size of left subarray would be 2
            // can be done by a linear search
            
            int maxIdx = lsi;
            for(int i = lsi; i <= lei; ++i){
                if(nums[i] > nums[maxIdx])
                    maxIdx = i;
            }
            
            return maxIdx;
        }
        
        int lmid = (lsi + lei) / 2;
        int rmid = (rsi + rei) / 2;
        
        if(nums[lmid] > nums[rmid])
            return getMaxIdx(lmid, lei, rsi, rmid - 1, nums);
        else 
            return getMaxIdx(lsi, lmid - 1, rmid, rei, nums);
    }
    
    private int getMaxIdx(int[] nums){
        int si = 0, ei = nums.length - 1;
        int mid = (si + ei) / 2;
        return getMaxIdx(si, mid, mid + 1, ei, nums);
    }
    
    public int search(int[] nums, int target) {
        
        int n = nums.length;        
        int pivot = getMaxIdx(nums); // idx of max element
        
        System.out.println(pivot);
        
        int si = 0;
        int ei = n - 1;
        
        while(si <= ei){
            int mid = (si + ei) / 2;
            int effectiveMid = (mid + pivot + 1) % n;
            if(nums[effectiveMid] == target)
                return effectiveMid;
            else if(nums[effectiveMid] > target)
                ei = mid - 1;
            else si = mid + 1;
        }
        
        return -1;
    }
}