class Solution {
    public String removeDuplicates(String s) {
        if(s.length() <= 1)
            return s;
        
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); ++i){
            if(!st.isEmpty() && st.peek() == s.charAt(i))
                st.pop();
            else
                st.push(s.charAt(i));
        }
        
        char[] res = new char[st.size()];
        int j = res.length;
        while(j --> 0)
            res[j] = st.pop();
        
        return new String(res);        
    }
}