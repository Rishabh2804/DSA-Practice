class Solution {
    public int appendCharacters(String s, String t) {
        
        int j = 0;
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == t.charAt(j)) j ++;
            
            if(j >= t.length()) break;
        }
        
        return t.length() - j;
    }
}