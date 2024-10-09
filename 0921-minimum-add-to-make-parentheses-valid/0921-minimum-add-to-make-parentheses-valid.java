class Solution {
    public int minAddToMakeValid(String s) {
        
        int count = 0;
        int open = 0, close = 0;
        
        for(int i = 0; i < s.length(); ++i){
            char curr = s.charAt(i);
            if(curr == '('){
                open++;
            } else {
                if(open == 0) count++;
                else open --;
            }
        }
        
        count += open;
        
        return count;
    }
}