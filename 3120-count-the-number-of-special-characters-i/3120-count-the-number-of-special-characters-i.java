class Solution {

    private static final byte UPPER = 1;   // 01
    private static final byte LOWER = 2;   // 10
    private static final byte SPECIAL = 3; // 11
    
    public int numberOfSpecialChars(String word) {
        
        byte[] reg = new byte[26];
        for(int i = 0; i < word.length(); ++i){
            char curr = word.charAt(i);

            int idx = (curr - 'A') % 32;
            byte charCase = (byte)((curr >> 5) - 1);
            
            reg[idx] |= charCase;
        }
        
        int count = 0;
        for(byte charType : reg){
            if(charType == SPECIAL) count++;
        }
                
        return count;
    }
}