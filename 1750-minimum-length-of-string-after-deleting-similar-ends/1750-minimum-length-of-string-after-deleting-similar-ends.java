class Solution {
    public int minimumLength(String s) {
        
        int si = 0, ei = s.length() - 1;
        while(si < ei){
            
            int startChar = s.charAt(si);
            int endChar = s.charAt(ei);
            
            if(startChar != endChar) break;
            
            while(si < ei && s.charAt(si) == startChar) si ++;
            while(si <= ei && s.charAt(ei) == endChar) ei --;            
        }
        
        return ei - si + 1;
    }
}