class Solution {
    static final char SPACE = ' ';
    
    public int lengthOfLastWord(String s) {
        
        int ei = s.length() - 1;
        while(ei >= 0 && s.charAt(ei) == SPACE) ei --;
        
        int si = ei;
        while(si >= 0 && s.charAt(si) != SPACE) si --;
        
        return ei - si;
    }
}