class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        for(int i = nums.length - 1; i >= 0; --i)
            st.add(nums[i]);
        
        int[] nge = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; --i){
            while(!st.isEmpty() && st.peek() <= nums[i])
                st.pop();
            
            if(st.isEmpty())
                nge[i] = -1;
            else nge[i] = st.peek();
            
            st.add(nums[i]);
        }
        
        return nge;
    }
}