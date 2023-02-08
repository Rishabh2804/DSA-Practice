class Solution {
    public int jump(int[] nums) {
        
        int[] jumpCount = new int[nums.length];
        Arrays.fill(jumpCount, Integer.MAX_VALUE - 1);
        
        jumpCount[0] = 0;
        for(int i = 0; i < nums.length; ++i){                        
            for(int j = i + 1; j <= Math.min(i + nums[i], nums.length - 1); ++j)
                jumpCount[j] = Math.min(jumpCount[j], 1 + jumpCount[i]);            
        }
        
        return jumpCount[nums.length - 1];
    }
}