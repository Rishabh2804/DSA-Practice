class Solution {
    
    static int[] buffer;
    
    public int[] sortArray(int[] nums) {     
        buffer = new int[nums.length];
        mergeSort(0, nums.length - 1, nums);
        return nums;
    }
    
    public void mergeSort(int si, int ei, int[] arr){
        if(si >= ei)
            return;
        
        int mid = (si + ei) / 2;
        mergeSort(si, mid, arr);
        mergeSort(mid + 1, ei, arr);
        
        int i = si;
        int j = mid + 1;
        int k = si;
        
        while(i <= mid && j <= ei){
            if(arr[i] <= arr[j])
                buffer[k++] = arr[i++];
            else
                buffer[k++] = arr[j++];
        }
        
        while(i <= mid)
            buffer[k++] = arr[i++];
        
        while(j <= ei)
            buffer[k++] = arr[j++];
        
        for(int ii = si; ii <= ei; ++ii)
            arr[ii] = buffer[ii];
    }
    
    
}