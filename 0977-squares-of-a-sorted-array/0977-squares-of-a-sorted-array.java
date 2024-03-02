class Solution {
    public int[] sortedSquares(int[] nums) {
        int si = 0, ei = nums.length - 1;
        
        int[] res = new int[nums.length];
        int k = nums.length;
        while(si < ei){
            int sqr1 = nums[si] * nums[si];
            int sqr2 = nums[ei] * nums[ei];
            
            if(sqr1 >= sqr2) {
                res[--k] = sqr1;
                si++;
            } else {
                res[--k] = sqr2;
                ei --;
            }
        }
        
        if(si == ei) res[--k] = nums[si] * nums[ei];
        
        return res;
    }
}