class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        int n = arr.length;
        Arrays.sort(arr);  
        
        int dec = arr[0] - 1;
        
        for(int i = 1; i < n; ++i){
            int effPrev = arr[i - 1] - dec;
            int effCurr = arr[i];
            
            if(effCurr - effPrev <= 1) {
                dec = 0;
                continue;
            }
            
            dec = effCurr - effPrev - 1;            
        }
        
        return arr[n - 1] - dec;
    }
}