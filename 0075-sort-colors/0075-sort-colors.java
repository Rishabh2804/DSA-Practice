class Solution {
    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        for(int i : nums) colors[i]++;
        
        int i = 0;
        while(colors[0] --> 0) nums[i++] = 0;
        while(colors[1] --> 0) nums[i++] = 1;
        while(colors[2] --> 0) nums[i++] = 2;                
    }
}