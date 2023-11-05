class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        
        int[] max = new int[n];
        max[0] = arr[0];
        
        int count = -1;
        for(int i = 1; i < n; ++i){
            max[i] = Math.max(arr[i], max[i - 1]);
            if(max[i] == max[i - 1]) count++;
            else count = 1;
            
            if(count >= k) return max[i];
        }
        
        return max[n - 1];        
    }
}