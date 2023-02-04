class Solution {
    static int[] freq1 = new int[26];
    static int[] freq2 = new int[26];
        
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        
        Arrays.fill(freq1, 0);
        Arrays.fill(freq2, 0);
        
        for(int i = 0; i < s1.length(); ++i)
            freq1[s1.charAt(i) - 'a']++;
        
        for(int i = 0; i < s1.length(); ++i)
            freq2[s2.charAt(i) - 'a']++;
        
        if(isIdentical(freq1, freq2)) return true;
        
        for(int i = s1.length(); i < s2.length(); ++i){
            int prevIdx = s2.charAt(i - s1.length()) - 'a';
            int currIdx = s2.charAt(i) - 'a';
            
            freq2[prevIdx]--;
            freq2[currIdx]++;
            
            if(isIdentical(freq1, freq2))
                return true;
        }
            
        return false;
    }
    
    private boolean isIdentical(int[] arr1, int[] arr2){
        
        for(int i = 0; i < arr1.length; ++i){
            if(arr1[i] != arr2[i])
                return false;                        
        }
        
        return true;
    }
}