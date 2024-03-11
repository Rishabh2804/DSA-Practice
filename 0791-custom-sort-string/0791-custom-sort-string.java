class Solution {
    public String customSortString(String order, String s) {
        
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); ++i){
            int idx = s.charAt(i) - 'a';
            freq[idx]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < order.length(); ++i){
            char curr = order.charAt(i);
            int count = freq[curr - 'a'];
            while(count --> 0) sb.append(curr);
            
            freq[curr - 'a'] = 0;
        }
        
        for(int i = 0; i < 26; ++i){
            char curr = (char)('a' + i);
            int count = freq[i];
            while(count --> 0) sb.append(curr);            
        }
        
        return sb.toString();
    }
}