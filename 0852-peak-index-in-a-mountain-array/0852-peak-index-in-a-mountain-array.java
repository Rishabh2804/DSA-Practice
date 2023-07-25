class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int si = 1;
        int ei = arr.length - 1;
        
        while(si <= ei){
            int mid = si + (ei - si) / 2;
            if(arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) // mountain peak
                return mid;
            else if(arr[mid - 1] <= arr[mid] && arr[mid] <= arr[mid + 1]) // forward slope
                si = mid + 1;
            else 
                ei = mid - 1;
        }
        
        return si;
    }
}