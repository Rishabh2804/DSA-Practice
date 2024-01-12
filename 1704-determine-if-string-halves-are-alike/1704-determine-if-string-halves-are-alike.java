class Solution {
    
    static final String VOWELS = "AEIOUaeiou";
    
    
    private final int isVowel(char c){
        return (VOWELS.indexOf(c) != -1) ? 1 : 0;
    }
    
    public boolean halvesAreAlike(String s) {
        int vowelCount = 0;
        
        for(int i = 0; i < s.length() / 2; ++i)
            vowelCount += isVowel(s.charAt(i));
        
        for(int i = s.length() / 2; i < s.length(); ++i)
            vowelCount -= isVowel(s.charAt(i));
        
        return vowelCount == 0;
    }
    
}