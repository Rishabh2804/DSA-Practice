class Solution {
    
    private void print(int[] arr){
        for(int i : arr)
            System.out.print(i + " ");
        
        System.out.println();
    }
    
    private int complement(int n, int maxBit){
        int[] bits = new int[maxBit];
        
        for(int i = 0; i < maxBit; ++i){
            int currBit = n & 1;
            n >>= 1;
            
            bits[i] = 1 - currBit;            
        }
        
        int not = 0;
        for(int i = maxBit - 1; i >= 0; --i){
            not <<= 1;
            not |= bits[i];
        }
        
        return not;    
    }
    
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        
        int n = nums.length;
        int[] xor = new int[n];
        
        xor[0] = nums[0];
        for(int i = 1; i < n; ++i)
            xor[i] = xor[i - 1] ^ nums[i];
        
        int[] res = new int[n];
        for(int k = 0; k < n; ++k)
            res[k] = complement(xor[n - k - 1], maximumBit);
        
        return res;
    }
}
