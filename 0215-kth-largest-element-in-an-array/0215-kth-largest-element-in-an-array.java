class Solution {
    
    public int quickSelect(int si, int ei, int [] nums){
        if(si > ei) return -1;
        if(si == ei) return si;
        
        int mid = si + (ei - si) / 2;
        
        int count = si;
        for(int i = si; i <= ei; ++i){
            if(nums[i] < nums[mid])
                count++;
        }
        
        int temp = nums[mid];
        nums[mid] = nums[count];
        nums[count] = temp;
        
        while(si < count){
            if(nums[si] >= nums[count]) {
                while(count < ei && nums[ei] >= nums[count]) ei--;
                
                int temp2 = nums[si];
                nums[si] = nums[ei];
                nums[ei] = temp2;
                
                ei--;
            }
            
            si++;
        }
        
        // System.out.println(count);
        // for(int i : nums){
        //     System.out.print(i + " ");
        // }
        // System.out.println();

        return count;
    }
    
    public int findKthLargest(int[] nums, int k) {
        
        int n = nums.length;
        
        // we will be finding out k1th smallest
        // element from the given array
        int k1 = n - k;
        int si = 0, ei = n - 1;
        
        int ans = 0;
        while(si <= ei){
            int pivot = quickSelect(si, ei, nums);
            if(pivot == k1){
                ans = pivot;
                si = pivot;
                break;
            }
            else if (pivot < k1)
                si = pivot + 1;
            else 
                ei = pivot - 1;
        }
        
//         System.out.println("Ans : ");

//         for(int i : nums){
//             System.out.print(i + " ");
//         }
        
//         System.out.println("\n");
        return nums[si];
    }
}