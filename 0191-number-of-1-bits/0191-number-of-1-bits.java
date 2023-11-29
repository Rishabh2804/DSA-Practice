public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if(n < 0) return 1 + hammingWeight(Integer.MIN_VALUE ^ n);
        
        if(n == 0) return 0;
        return (n & 1) + hammingWeight(n >> 1);
    }
}