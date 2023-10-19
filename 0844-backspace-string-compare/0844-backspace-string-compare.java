class Solution {
    
    static final char BACK_SPC = '#';
    
    private Stack<Character> getFinalInput(String str){
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < str.length(); ++i){
            if(str.charAt(i) == BACK_SPC){
                if(!st.isEmpty()) st.pop();
            } else st.add(str.charAt(i));
        }
        
        return st;
    }
    
    private boolean compare(Stack<Character> st1, Stack<Character> st2){
        if(st1.size() != st2.size()) return false;
        
        while(!st1.isEmpty()){
            if(st1.pop() != st2.pop()) return false;
        }
        
        return true;
    }
    
    public boolean backspaceCompare(String s, String t) {
        return compare(
            getFinalInput(s),
            getFinalInput(t)
        );
    }
}