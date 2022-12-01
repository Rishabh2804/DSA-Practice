class Solution {
    public boolean halvesAreAlike(String s) {
        int vowelCount = 0;
        
        for(int i = 0; i < s.length() / 2; ++i)
            vowelCount += isVowel(s.charAt(i));
        
        for(int i = s.length() / 2; i < s.length(); ++i)
            vowelCount -= isVowel(s.charAt(i));
        
        return vowelCount == 0;
    }
    
    public int isVowel(char c){
        switch(c){        
            case 'a' :    
            case 'e' : 
            case 'i' : 
            case 'o' : 
            case 'u' : 
            case 'A' :    
            case 'E' : 
            case 'I' : 
            case 'O' : 
            case 'U' : return 1;                      
            default  : return 0; 
        }
    }
}