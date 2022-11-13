class Solution {
    public String reverseWords(String s) {
        Stack<String> words = new Stack<>();
        
        int si = 0, ei = 0;
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == ' '){
                if(si < ei)
                    words.push(s.substring(si, ei));
                
                si = i + 1;
                ei = i + 1;
            }
            else
                ei++;
        }
                
        if(si < ei)                                
            words.push(s.substring(si, ei));
        
        String reversed;
        if(!words.isEmpty())
            reversed = words.pop();
        else
            return "";
        
        while(!words.isEmpty())
            reversed += " " + words.pop();
        
        return reversed;
    }
}