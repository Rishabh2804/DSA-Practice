class Solution {
    
    public int bitDiff(int a, int b){
        int count = 0;
        while(a > 0 || b > 0){
            count += (a & 1) ^ (b & 1);
            // System.out.println((a & 1) ^ (b & 1));
            a >>= 1;
            b >>= 1;
        }
        
        return count;
    }
    
    public int minOperations(int[] nums, int k) {
        int xor = 0;
        for(int i : nums) xor ^= i;
        
        return bitDiff(xor, k);
    }
}