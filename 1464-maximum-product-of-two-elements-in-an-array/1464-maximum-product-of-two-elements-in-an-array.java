class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        int maxProd = 0;
        for(int i = 0; i < n; ++i){
            for(int j = i + 1; j < n; ++j)
                maxProd = Math.max(maxProd, (nums[i] - 1) * (nums[j] - 1));
        }
        
        return maxProd;
    }
}