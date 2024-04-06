class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> idx = new Stack<>();        
        boolean[] reg = new boolean[s.length()];
        
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '(') idx.add(i);
            else if(s.charAt(i) == ')'){
                if(!idx.isEmpty()) {
                    int lastOpen = idx.pop();
                    reg[lastOpen] = true;
                    reg[i] = true;
                }
            } else reg[i] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            if(reg[i]) sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}