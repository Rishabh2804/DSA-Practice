class Solution {
    
    private int solve(int i, int xor, int[] nums){
        if(i >= nums.length) return xor;
        
        int leave = solve(i + 1, xor, nums);        
        int take = solve(i + 1, nums[i] ^ xor, nums);
        
        return leave + take;        
    }
    
    public int subsetXORSum(int[] nums) {
        return solve(0, 0, nums);    
    }
}