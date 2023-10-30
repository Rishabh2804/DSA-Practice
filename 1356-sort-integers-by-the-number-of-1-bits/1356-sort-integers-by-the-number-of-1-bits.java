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
        int[] bits = new int[arr.length];
        for(int i = 0; i < arr.length; i++)
            bits[i] = countBits(arr[i]) * 100000 + arr[i];
        
        Arrays.sort(bits);
        for(int i = 0; i < arr.length; i++)
            bits[i] = bits[i] % 100000;
        
        return bits;
    }
}