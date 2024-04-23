class Solution {
    public String breakPalindrome(String s) {
        
        if (s.length() == 0 || s.length() == 1)
            return "";
        
        int i = 0 , j = s.length()-1;
        int idx = -1;
        while (i < j) {
            
            if (s.charAt(i) != 'a' && s.charAt(j) != 'a') {
                idx = i;
                break;
            }
            i++;
            j--;
        }
        
        if (idx == -1) {
            char c = s.charAt(s.length()-1);
            if (c == 'a') {
                String temp = s.substring(0,s.length()-1);
                temp += 'b';
                return temp;
            }
        }

        String temp = s.substring(0,idx);
        temp = temp+'a';
        
        if (idx+1 < s.length()) {
            temp += s.substring(idx+1);
        }
        
        return temp;
        
    }
}