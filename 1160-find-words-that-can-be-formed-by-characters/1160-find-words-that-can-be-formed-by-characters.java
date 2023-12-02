class Solution {
    
    private boolean isIdentical(int[] arr1, int[] arr2){
        for(int i = 0; i < arr1.length; ++i)
            if(arr1[i] > arr2[i]) return false;
        
        return true;
    }
    
    private int[] getFreq(String word){
        int[] freq = new int[26];
        for(int i = 0; i < word.length(); ++i)
            freq[word.charAt(i) - 'a']++;
        
        return freq;
    }
    
    private boolean check(String word, int[] freq){        
        return isIdentical(getFreq(word), freq);        
    }
    
    public int countCharacters(String[] words, String chars) {
        int count = 0;
        
        int[] freq = getFreq(chars);
        
        for(String word : words){
            if(check(word, freq)) 
                count += word.length();
        }
        
        return count;
    }
}