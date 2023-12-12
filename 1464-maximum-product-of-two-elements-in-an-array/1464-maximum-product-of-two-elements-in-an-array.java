class Solution {
    
    // TC : O(n*n)
    // SC : O(1)
    private int solve1(int[] nums){
        int n = nums.length;
        
        int maxProd = 0;
        for(int i = 0; i < n; ++i){
            for(int j = i + 1; j < n; ++j)
                maxProd = Math.max(maxProd, (nums[i] - 1) * (nums[j] - 1));
        }
        
        return maxProd;
    }
    
    // TC : O(nlog(n))
    // SC : O(1)
    private int solve2(int[] nums){
        Arrays.sort(nums);
        
        int n = nums.length;
        
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }
    
    // TC : O(n)
    // SC : O(1)
    private int solve3(int[] nums){
        int largest = 0;
        int largest2 = 0;
        
        for(int num : nums){
            if(num > largest) {
                largest2 = largest;
                largest = num;                    
            } else if(num > largest2)
                largest2 = num;
        }
        
        return (largest - 1) * (largest2 - 1);
    }
    
    public int maxProduct(int[] nums) {
        return solve3(nums);
    }
}