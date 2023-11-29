public class Solution {
    // you need to treat n as an unsigned value
    
    // Recursive
    private int solve1(int n){
        if(n < 0) return 1 + solve1(Integer.MIN_VALUE ^ n);
        
        if(n == 0) return 0;
        return (n & 1) + solve1(n >> 1);
    }
        
    // Iterative
    private int solve2(int n){
        if(n < 0) return 1 + solve2(Integer.MIN_VALUE ^ n);
        
        int count = 0;
        for(int bit = 0; bit < 31; ++bit){
            boolean bitSet = (n & (1 << bit)) != 0;
            if (bitSet) count++;
        }

        return count;
    }
    
    public int hammingWeight(int n) {
        if(n % 2 == 0) return solve1(n);
        else return solve2(n);
    }
}