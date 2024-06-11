class Solution {
    private void print(int[] arr){
        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] == 0) continue;
            System.out.println(i + " " + arr[i]);
        }
    }
    
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];
                
        Arrays.sort(arr1);
        
        for(int i : arr1) freq[i]++;
        
        
        int k = 0;
        for(int i : arr2){
            int curr = i;            
            while(freq[curr] --> 0) arr1[k++] = curr;
        }
        
        for(int i = 0; i < 1000; ++i){
            if(freq[i] == 0) continue;
            
            int curr = i;
            while(freq[curr] --> 0) arr1[k++] = curr;
        }
        
        return arr1;
    }
}