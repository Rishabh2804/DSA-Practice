class Solution {
    
    private int solve(int i, String s, int[] count){
        if(i >= s.length()) return 0;
        
        if(s.charAt(i) == 'a') return solve(i + 1, s, count);
        
        int removeCurr = 1 + solve(i + 1, s, count);
        int removeAllA = count[i];
        
        return Math.min(removeCurr, removeAllA);
    }
    
    public int minimumDeletions(String s) {
        
        int[] count = new int[s.length()];
        count[s.length() - 1] = (s.charAt(s.length() - 1) == 'a') ? 1 : 0;
        
        for(int i = s.length() - 2; i >= 0; --i){
            if(s.charAt(i) == 'a') count[i]++;
            
            count[i] += count[i + 1];
        }
        
        return solve(0, s, count);
    }
}