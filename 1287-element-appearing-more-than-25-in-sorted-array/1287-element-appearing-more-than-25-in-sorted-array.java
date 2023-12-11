class Solution {
    
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int qLen = 1 + (n / 4);
        
        int count = 1;
        for(int i = 1; i < n; ++i){
            if(arr[i] == arr[i - 1]) count ++;
            else count = 1;
            
            if(count >= qLen) return arr[i];
        }
                
        return arr[0];
    }
}