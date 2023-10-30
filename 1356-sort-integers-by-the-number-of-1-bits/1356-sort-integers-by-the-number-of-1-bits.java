class Solution {
    private int countBits(int n){
        int count = 0;
        while(n != 0){
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
    
    public int[] sortByBits(int[] arr) {
        for(int i = 0; i < arr.length; i++)
            arr[i] += countBits(arr[i]) * 100000;
        
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++)
            arr[i] %= 100000;
        
        return arr;
    }
}