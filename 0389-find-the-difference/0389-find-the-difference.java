class Solution {
    public char findTheDifference(String s, String t) {
        int[] freq = new int[26];
        for(int i = 0; i < t.length(); ++i){
            int index = t.charAt(i) - 'a';
            freq[index]++;
        }
        
        for(int i = 0; i < s.length(); ++i){
            int index = s.charAt(i) - 'a';
            freq[index]--;
        }
        
        for(int i = 0; i < 26; ++i){
            if(freq[i] > 0) return (char)(i + 'a');
        }
        
        return 'a';
    }
}