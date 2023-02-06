class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int[] res = new int[2 * n];
        int j = 0;
        for(int i = 0; i < n; ++i){
            res[j] = nums[i];
            j += 2;
        }
        
        j = 1;
        for(int i = n; i < 2 * n; ++i){
            res[j] = nums[i];
            j += 2;
        }
        
        System.gc();
        return res;
    }        
}