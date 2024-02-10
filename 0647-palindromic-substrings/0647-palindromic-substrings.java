class Solution {
    public int countSubstrings(String s) {
        
        int count = 0;
        
        // Odd length palindromes
        for(int i = 0; i < s.length(); ++i){
            
            int left = i;
            int right = i;
            
            while(left >= 0 && right < s.length()){
                if(s.charAt(left) == s.charAt(right)) count ++;
                else break;
                
                left --;
                right++;
            }
        }
        
        // Even length palindromes
        for(int i = 0; i < s.length() - 1; ++i){
            
            int left = i;
            int right = i + 1;
            
            while(left >= 0 && right < s.length()){
                if(s.charAt(left) == s.charAt(right)) count ++;
                else break;
                
                left --;
                right++;
            }
        }
        
        return count;
    }
}