class Solution {
    
    public int minPatches(int[] nums, int n) {
        long maxNumber = 0;
        int l = nums.length, patches = 0, i=0;
        while (maxNumber < n) {
            if(i<l && maxNumber + 1 >= nums[i]){
                maxNumber += nums[i];
                i++;
            } else {
                patches++;
                maxNumber += maxNumber+1;
            }
        }
        return patches;
    }
}