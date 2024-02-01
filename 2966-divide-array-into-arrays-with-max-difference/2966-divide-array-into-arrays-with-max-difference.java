class Solution {
    private void print(int[] arr){
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        
        print(nums);
        
        int n = nums.length;
        int[][] res = new int[n / 3][3];
        
        for(int i = 0; i < res.length; ++i){
            for(int j = 0; j < 3; ++j){
                int i1 = 3 * i + j;
                if(j > 0 && nums[i1] > nums[i1 - j] + k) 
                    return new int[][]{};
                
                res[i][j] = nums[i1];
            }            
        }
        
        return res;            
    }
}