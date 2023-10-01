class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String res = reverse(words[0]);
        
        for(int i = 1; i < words.length; ++i)
            res += " " + reverse(words[i]);
        
        return res;        
    }
    
    public String reverse(String s){
        char[] str = s.toCharArray();
        
        for(int i = 0; i < str.length / 2; ++i){
            char temp = str[i];
            str[i] = str[str.length - i - 1];
            str[str.length - i - 1] = temp;
        }
        
        return new String(str);
    }
}