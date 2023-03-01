class Solution {
    public int[] sortArray(int[] nums) {
        // quickSort(0, nums.length - 1, nums);
        Arrays.sort(nums);
        return nums;
    }
    
    public void quickSort(int si, int ei, int[] arr) {
        if(si >= ei)
            return;
        
        int pivot = partition(si, ei, arr);
        quickSort(si, pivot - 1, arr);
        quickSort(pivot + 1, ei, arr);
    }
    
    public int partition(int si, int ei, int[] arr){
        int mid = (si + ei) / 2;
        
        int count = si;
        for(int i = si; i <= ei; ++i){
            if(arr[i] < arr[mid])
                count ++;
        }
        
        int temp = arr[mid];
        arr[mid] = arr[count];
        arr[count] = temp;
        
        int i = si, j = ei;
        while(i < count){
            if(arr[i] >= arr[count]){
                while(j > count && arr[j] >= arr[count])
                    j--;

                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }

            i++;                
        }
        
        return count;    
    }
}