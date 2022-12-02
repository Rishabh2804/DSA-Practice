class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length())
            return false;
        
        int[] alpha1 = new int[26];
        int[] alpha2 = new int[26];
        
        for(int i = 0; i < word1.length(); ++i){
            alpha1[word1.charAt(i) - 'a']++;
            alpha2[word2.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < 26; ++i){
            if(alpha1[i] != 0 && alpha2[i] == 0)
                return false;
            else if(alpha2[i] != 0 && alpha1[i] == 0)
                return false;
        }
        
        Arrays.sort(alpha1);
        Arrays.sort(alpha2);
        
        for(int i = 0; i < 26; ++i){
            if(alpha1[i] != alpha2[i])
                return false;
        }
            
        return true;
    }
}