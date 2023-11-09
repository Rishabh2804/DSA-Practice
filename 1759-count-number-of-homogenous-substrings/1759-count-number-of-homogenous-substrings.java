class Solution {
    static final int MOD = 1000000007;
    
    private static final int getTriangle(int n){
        return (int)((1L * n * (n + 1) / 2) % MOD);
    }
    
    public int countHomogenous(String s) {
        int count = 0;
        
        int seqLen = 1;
        for(int i = 1; i < s.length(); ++i){
            if(s.charAt(i) == s.charAt(i - 1)) seqLen ++;
            else {
                count = (count + getTriangle(seqLen)) % MOD;
                seqLen = 1;
            }
        }
        
        count = (count + getTriangle(seqLen)) % MOD;
        
        return count;
    }
}