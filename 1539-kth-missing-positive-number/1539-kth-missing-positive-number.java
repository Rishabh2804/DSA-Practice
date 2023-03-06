class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int lastMis = 0;
        int last = 0;
        for(int i = 0; i < arr.length; ++i){
            int mis = arr[i] - i - 1;
            if(mis >= k)
                return last + (k - lastMis);
            
            last = arr[i];
            lastMis = mis;
        }
        
        return last + (k - lastMis);
    }
}