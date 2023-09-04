class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = new int[nums.length];
        for(int i = 0; i < nums.length; ++i)
            sorted[i] = nums[i];
        
        Arrays.sort(sorted);
        
        int si = -1, ei = -1;
        for(int i = 0; i < nums.length; ++i){
            if(sorted[i] != nums[i]){
                if(si == -1)
                    si = i;
                
                ei = i;
            }
        }
        
        if(si == -1) return 0;
        else return ei - si + 1;
    }
}