class Solution {
    static final String EMPTY = "";
   
    static final boolean isDigit(char c){
        return '0' <= c && c <= '9';
    }
    
    static final int mod(int x, long n){
        return 1 + (int)((x - 1) % n);
    }
    
    private String solve(int k, long currLen, Stack<Character> st){
        
        while(currLen >= k && !st.isEmpty()){
            char top = st.pop();
            
            if(isDigit(top)){
                int dig = top - '0';
                
                currLen /= dig;
                k = mod(k, currLen);
            } else{
                if(currLen == k) return "" + top;
                else currLen --;
            }
        }
        
        return EMPTY;
    }
    
    public String decodeAtIndex(String s, int k) {
        
        Stack<Character> st = new Stack<>();
        long len = 0;
        for(int i = 0; i < s.length(); ++i){
            char curr = s.charAt(i);
            st.add(curr);

            if(isDigit(curr)) {
                int dig = curr - '0';
                len *= dig;
            } else len++;
                        
            if(len >= k) return solve(k, len, st);
        }
        
        return EMPTY;
    }
}