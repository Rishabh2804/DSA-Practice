class Solution {
    public boolean match(String str1, String str2){
        for(int i = 0; i < str1.length(); i += str2.length()){
            if(!str2.equals(str1.substring(i, i + str2.length())))
                return false;
        }
        
        return true;
    }

    public boolean repeatedSubstringPattern(String s) {
        if(s.length() <= 1) return false;
        
        for(int i = s.length() / 2; i > 0; --i){
            if(s.length() % i == 0 && match(s, s.substring(0, i)))
                return true;
        }        
        
        return false;
    }
}