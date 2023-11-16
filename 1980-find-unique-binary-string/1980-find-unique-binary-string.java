class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();

        char combined = '0' + '1';
        for(int i = 0; i < nums.length; ++i)
            ans.append((char)(combined - nums[i].charAt(i)));
        
        return ans.toString();
    }
}