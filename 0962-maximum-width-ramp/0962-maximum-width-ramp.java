class Solution {
    
    public int maxWidthRamp(int[] nums) {
        
        int[][] indices = new int[nums.length][2];
        for(int i = 0; i < nums.length; ++i){
            indices[i] = new int[]{nums[i], i};
        }
        
        Arrays.sort(indices, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });
        
        int maxWidth = 0;
        int lo = nums.length;
        for(int i = 0; i < nums.length; ++i){            
            lo = Math.min(lo, indices[i][1]);
            maxWidth = Math.max(maxWidth, indices[i][1] - lo);
        }
        
        return maxWidth;
    }
}