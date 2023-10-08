class Solution {
    
    static final int MIN_VALUE = -100000000;
    
    private int solve(int si1, int si2, int[] nums1, int[] nums2, Integer[][] dp){
        if(si1 >= nums1.length || si2 >= nums2.length)
            return MIN_VALUE;
        
        if(dp[si1][si2] != null)
            return dp[si1][si2];
        
        int leave = solve(si1 + 1, si2, nums1, nums2, dp);
        
        int take = MIN_VALUE;
        for(int i = si2; i < nums2.length; ++i){
            int product = nums1[si1] * nums2[i];
            int dotProd = solve(si1 + 1, i + 1, nums1, nums2, dp);
            
            int currAns = Math.max(product, product + dotProd);
            // currAns = Math.max(currAns, product + dotProd);
            
            take = Math.max(take, currAns);
        }
        
        return dp[si1][si2] = Math.max(leave, take);
    }
    
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        return solve(0, 0, nums1, nums2, new Integer[n][m]);
    }
}