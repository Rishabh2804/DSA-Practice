class Solution {
    static final int SI = 0;
    static final int EI = 1;
    static final int LEN = 2;
    
    private int[] expand(int si, int ei, String s){
        if(si < 0 || ei >= s.length()) return new int[]{0, -1, 0};
        
        while(si >= 0 && ei < s.length()){
            if(s.charAt(si) == s.charAt(ei)){
                si--;
                ei++;
            } else break;
        }
        
        si++;
        ei--;
        
        return new int[]{si, ei, ei - si + 1};
    }
    
    private int[] getPalBounds(int i, String s){
        int[] leftExp = expand(i - 1, i, s);
        int[] rightExp = expand(i, i + 1, s);
        int[] equiExp = expand(i, i, s);
        
        if(leftExp[LEN] >= rightExp[LEN]){
            if(leftExp[LEN] >= equiExp[LEN]) return leftExp;
            else return equiExp;
        } 
        else if(rightExp[LEN] >= equiExp[LEN]) return rightExp;
        else return equiExp;
    }
    
    public String longestPalindrome(String s) {
        
        int[] maxBounds = {0, 0, 1};
        for(int i = 0; i < s.length(); ++i){
            int[] palBounds = getPalBounds(i, s);
            if(palBounds[LEN] >= maxBounds[LEN])
                maxBounds = palBounds;
        }
        
        return s.substring(maxBounds[SI], maxBounds[EI] + 1);
    }
}