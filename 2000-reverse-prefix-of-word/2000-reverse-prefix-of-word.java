class Solution {
    
    private void reverse(char[] seq, int si, int ei){
        int len = ei - si;
        for(int i = si; i < len / 2; ++i){
            char curr = seq[i];
            seq[i] = seq[len - i - 1];
            seq[len - i - 1] = curr;
        }
    }
    
    public String reversePrefix(String word, char ch) {
        
        char[] letters = word.toCharArray();
        for(int i = 0; i < letters.length; ++i){
            if(letters[i] == ch) {
                reverse(letters, 0, i + 1);
                break;
            }
        }
        
        return new String(letters);
    }
}