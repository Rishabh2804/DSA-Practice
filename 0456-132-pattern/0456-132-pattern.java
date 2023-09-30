class Solution {
    public boolean find132pattern(int[] nums) {
        int s3 = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        for(int i = nums.length - 1; i >= 0; --i){
            if(nums[i] < s3) 
                return true;
            else {
                while( !st.isEmpty() && nums[i] > st.peek())
                    s3 = st.pop();
            }
            st.push(nums[i]);
        }
        
        return false;
    }
}