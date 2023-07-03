class Solution {
    static final int[] freq = new int[26];
    
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;
        
        char s1 = '.', s2 = '.';
        char g1 = '*', g2 = '*';
        
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) != goal.charAt(i)){
                if(s1 == '.') {
                    s1 = s.charAt(i);
                    g1 = goal.charAt(i);
                } else if(s2 == '.') {
                    s2 = s.charAt(i);
                    g2 = goal.charAt(i);
                } else return false;
            }
        }
        
        if(s1 == g2 && s2 == g1)
            return true;
        else if(!s.equals(goal))
            return false;
        
        // if both strings are identical, then we can swap two identical characters as well
        Arrays.fill(freq, -1);
        for(int i = 0; i < s.length(); ++i){
            int idx = s.charAt(i) - 'a';
            if(freq[idx] == -1) freq[idx] = 0;
            
            freq[idx]++;
            
            if(freq[idx] == 2) return true;
        }
        
        return false;
    }
}