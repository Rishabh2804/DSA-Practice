class Solution {
    public String makeGood(String s) {
        
        Stack<Character> good = new Stack<>();
        for(int i = s.length() - 1; i >= 0; --i){
            if(!good.isEmpty() && checkBad(good.peek(), s.charAt(i)))
                good.pop();
            else
                good.push(s.charAt(i));
        }
        
        String ans = "";
        while(!good.isEmpty())
            ans += good.pop();
        
        return ans;
    }
    
    public boolean checkBad(char c1, char c2){
        return Math.abs(c1 - c2) == 32;
    }
}