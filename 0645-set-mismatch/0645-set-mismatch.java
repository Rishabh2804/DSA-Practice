class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] freq = new int[nums.length + 1];
        for(int num : nums)
            freq[num]++;
        
        int ans1 = 0, ans2 = 0;
        for(int num = 1; num <= nums.length; ++num){
            if(freq[num] > 1)
                ans1 = num;
            
            if(freq[num] == 0)
                ans2 = num;
        }
        
        return new int[]{ans1, ans2};
    }
}