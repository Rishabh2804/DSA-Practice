class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        int n = arr.length;
        Arrays.sort(arr);  
        
        // int dec = arr[0] - 1;
        int dec = 0;
        arr[0] = 1;
        
        for(int i = 1; i < n; ++i){
            int effPrev = arr[i - 1] - dec;
            int effCurr = arr[i] - dec;
            
            if(effCurr - effPrev <= 1) continue;
            
            arr[i] = arr[i - 1] + 1;
            // dec = arr[i] - effPrev - 1;            
        }
        
        // System.out.println(arr[n - 1] + " " + dec);
        
        return arr[n - 1] - dec;
    }
}