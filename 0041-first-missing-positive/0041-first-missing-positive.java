class Solution {
    public int firstMissingPositive(int[] arr) {
        
        for(int i = 0; i < arr.length; ++i){
            while(arr[i] > 0 && arr[i] <= arr.length && arr[i] != i + 1){
                int temp = arr[arr[i] - 1];
                if(temp == arr[i])
                    break;
                
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }
        
        for(int i = 0; i < arr.length; ++i){
            if(arr[i] != i + 1)
                return i + 1;
        }
        
        return arr.length + 1;
    }
}