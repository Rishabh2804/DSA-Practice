class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] idx = new int[26];
        int maxLen = -1;
        
        for(int i = 0; i < s.length(); ++i){
            int curr = s.charAt(i) - 'a';
            if(idx[curr] == 0) {
                idx[curr] = i + 1;
                continue;
            }
            
            maxLen = Math.max(maxLen, i - idx[curr]);
        }
        
        return maxLen;
    }
}