class Solution {
    public int getSum(int a, int b) {
        if(a == b) return a << 1;        
        if((a & b) == 0) return a | b;
        
        int and = a & b;
        int or = a | b;
        return getSum(or ^ and, and << 1);
    }
}