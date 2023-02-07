class Solution {
    public int findTheLongestSubstring(String s) {
        
        int[] masks = new int[32];
        Arrays.fill(masks, -1);
        masks[0] = 0;
        
        int[] strMasks = new int[s.length()];
        strMasks[0] = vowelMask(s.charAt(0));
        masks[strMasks[0]] = 0;
        
        int maxLength = 0;
        if(strMasks[0] == 0)
            maxLength = 1;
        
        for(int i = 1; i < s.length(); ++i){
            strMasks[i] = strMasks[i - 1] ^ vowelMask(s.charAt(i));
            
            if(strMasks[i] == 0)
                maxLength = i + 1;            
            else if(masks[strMasks[i]] != -1) {
                int length = i - masks[strMasks[i]];
                maxLength = Math.max(maxLength, length);
            } else masks[strMasks[i]] = i;
        }                
        
        return maxLength;
    }
    
    public int vowelMask(char c){
        if(c == 'a')      return 1;
        else if(c == 'e') return 2;
        else if(c == 'i') return 4;
        else if(c == 'o') return 8;
        else if(c == 'u') return 16;
        else            return 0;
    }
}