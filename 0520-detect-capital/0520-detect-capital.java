class Solution {
    public boolean detectCapitalUse(String word) {
        boolean lower = false, upper = false;
        
        lower = (word.charAt(0) >= 'a' && word.charAt(0) <= 'z');        
        for(int i = 1;i < word.length(); ++i){
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')
                upper = true;                
            else if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')
                lower = true;
            
            if(upper && lower)
                return false;            
        }
        
        return true;
    }
}