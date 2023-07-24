class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(x == 0 || x == 1) return x;
        if(x == -1) {
            // if(n % 2 == 0) return 1;
            // else return -1;
            
            return 1 - 2 * (n % 2);
        }
        
        if(n == 1) return x;        
        
        double ans = myPow(x, n / 2);
        ans *= ans; // squaring the half-powered ans
        
        if(n % 2 == 1 || n % 2 == -1) {
            if(n > 0) ans *= x;   
            else ans /= x;
        }
        
        return ans;
    }
}