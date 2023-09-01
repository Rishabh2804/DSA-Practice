class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for(int i = 1; i <= n; ++i){
            int firstZero = i ^ (i - 1);
            firstZero = (firstZero + 1) / 2;
            ans[i] = 1 + ans[(i - 1) / firstZero];
        }
        
        return ans;
    }
}