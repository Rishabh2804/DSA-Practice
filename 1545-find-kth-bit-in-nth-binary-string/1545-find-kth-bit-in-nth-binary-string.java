class Solution {
    
    private char flip(char c){
        return c == '0' ? '1' : '0';
    }
    
    private boolean isPower2(int n){
        if(n == 1) return false;
        return (n & (n - 1)) == 0;
    }
    
    public char findKthBit(int n, int k) {
        if(k == 1) return '0';
        else if (isPower2(k)) return '1';
        
        int len = (1 << n) - 1;
        int halfLen = (len - 1) >> 1;
    
        if(k <= halfLen) return findKthBit(n - 1, k);
        else return flip(findKthBit(n - 1, len - k + 1));        
    }
}