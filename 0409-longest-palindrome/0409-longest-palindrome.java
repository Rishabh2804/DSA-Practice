class Solution {
    public int longestPalindrome(String s) {
        
        int count = 0;
        boolean odd = false;
        
        int[] freq = new int[84];
        for(int i = 0; i < s.length(); ++i)
            freq[s.charAt(i) - 'A']++;
        
        for(int i : freq) {
            count += 2 * (i / 2);            
            odd |= i % 2 == 1;
        }
        
        if(odd) count++;
        
        return count;
    }
}