class Solution {
    static final char ANCHOR = '.';
    
    public String removeDuplicateLetters(String s) {
        
        Stack<Character> st = new Stack<>();
        
        int[] freq = new int[26];        
        Integer[] indices = new Integer[26];
        
        for(int i = 0; i < s.length(); ++i)
            freq[s.charAt(i) - 'a']++;
        
        for(int i = 0; i < s.length(); ++i){
                
            char curr = s.charAt(i);
            int idx = curr - 'a';
            
            freq[idx] --;
            
            if(indices[idx] != null) continue;
            
            while(!st.isEmpty() && st.peek() >= curr && freq[st.peek() - 'a'] > 0) {
                indices[st.peek() - 'a'] = null;
                st.pop();
            }
            
            st.add(curr);
            indices[idx] = i;
        }
        
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            
            char curr = s.charAt(i);
            int idx = curr - 'a';
            
            if(indices[idx] == i) res.append(curr);
        }
        
        return res.toString();
    }
}