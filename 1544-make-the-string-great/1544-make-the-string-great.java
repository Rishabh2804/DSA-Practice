class Solution {
    public String makeGood(String s) {
        
        Stack<Character> good = new Stack<>();
        for(int i = s.length() - 1; i >= 0; --i){
            if(!good.isEmpty() && checkBad(good.peek(), s.charAt(i)))
                good.pop();
            else
                good.push(s.charAt(i));
        }
        
        StringBuilder ans = new StringBuilder();
        while(!good.isEmpty())
            ans.append(good.pop());
        
        return ans.toString();
    }
    
    public boolean checkBad(char c1, char c2){
        return Math.abs(c1 - c2) == 32;
    }
}