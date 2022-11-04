class Solution {
    public String reverseVowels(String s) {
        
        char[] res = s.toCharArray();

        int si = 0, ei = s.length() - 1;
        while(si < ei){
            while(si < ei && !isVowel(res[si]))
                si++;

            while(ei > si && !isVowel(res[ei]))
                ei--;
            
            if(si >= ei)
                break;

            char temp = res[si];
            res[si] = res[ei];
            res[ei] = temp;

            si++;
            ei--;
        }
        
        return new String(res);
    }

    public boolean isVowel(char c){
        return (
            c == 'a' || 
            c == 'e' || 
            c == 'i' || 
            c == 'o' ||
            c == 'u' ||
            c == 'A' ||
            c == 'E' ||
            c == 'I' ||
            c == 'O' ||
            c == 'U'
        );
    }
}