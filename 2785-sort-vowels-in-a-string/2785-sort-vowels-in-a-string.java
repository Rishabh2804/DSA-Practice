class Solution {
    
    static final String VOWELS = "AEIOUaeiou";
    
    public boolean isVowel(char c){
        return VOWELS.indexOf(c) >= 0;        
    }
    
    public String sortVowels(String s) {
        
        ArrayList<Character> vowels = new ArrayList<>();
        
        char[] arr = s.toCharArray();
        for(int i = 0; i < s.length(); ++i){
            if(isVowel(arr[i]))
                vowels.add(arr[i]);
        }
        
        Collections.sort(vowels);
        int j = 0;
        for(int i = 0; i < s.length(); ++i){
            if(isVowel(arr[i]))
                arr[i] = vowels.get(j++);
        }
        
        return new String(arr);
    }
}