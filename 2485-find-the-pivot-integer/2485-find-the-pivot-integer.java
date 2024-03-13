class Solution {
    
    // Let S(x, y) = (x..y)Σn = Σy - Σx = (y(y + 1) - x(x + 1)) / 2
    // lSum = S(1, x)
    // rSum = S(x, n)
    
    // lSum = rSum
    // S(1, x) = S(x, n)
    // x(x + 1) / 2 = (n(n + 1)/2) - (x(x - 1)/2)
    // x(x + 1) = n(n + 1) - x(x - 1)
    // x(x + 1 + x - 1) = n(n + 1)
    // 2x*x = n(n + 1)
    // x = sqrt(n(n + 1) / 2)
    
    private int sqrt(int n){
        
        int i = 1;
        while(i * i <= n) i++;
        i--;
        
        if(i * i == n) return i;
        else return -1;            
    }
    
    public int pivotInteger(int n) {
        
        int sum = n * (n + 1);
        sum /= 2;
        
        return sqrt(sum);
    }
}