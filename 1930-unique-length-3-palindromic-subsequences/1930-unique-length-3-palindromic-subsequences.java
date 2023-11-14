class Solution {
    static final int SI = 0;
    static final int EI = 1;
    
    private int countDistinct(int si, int ei, String s){
        HashSet<Character> dictionary = new HashSet<>();
        for(int i = si; i < ei; ++i)
            dictionary.add(s.charAt(i));
        
        return dictionary.size();
    }
    
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        
        int[][] occurences = new int[26][2];        
        for(int i = 0; i < 26; ++i)
            occurences[i] = new int[]{n, -1};
        
        int count = 0;
        for(int i = 0; i < n; ++i){
            int idx = s.charAt(i) - 'a';
            
            occurences[idx][SI] = Math.min(occurences[idx][SI], i);
            occurences[idx][EI] = Math.max(occurences[idx][EI], i);            
        }
        
        for(int[] occurence : occurences)
            count += countDistinct(occurence[SI] + 1, occurence[EI], s);
        
        return count;
    }
}