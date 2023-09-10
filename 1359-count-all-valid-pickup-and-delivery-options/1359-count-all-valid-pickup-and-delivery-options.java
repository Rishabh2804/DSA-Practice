class Solution {
    
    // The given problem can be solved easily by just 
    // visualising the problem in resursive manner
    
    // Let C(n - 1) be the count of all possible sequences for n - 1 orders
    
    // Now, the length of every sequence for n - 1 orders would be 2*(n - 1)
    // (2*Pickups + 2*Deliveries for each order)  
    // E.g. for n == 3, n - 1 == 2,
    // Possible sequence : P1D1P2D2
    
    // To insert Pickup P3 of 3rd order, possible no of ways are
    // ways_P = 1 + length of sequence
    //        = 1 + 2*(n - 1)
    //        = 2 * n - 1
    // Let  m = 2 * (n - 1)  ==>  ways_P = m + 1
    
    // For every possible positioning of P, at ith position in sequence,
    // possible ways for positioning of D: 
    // ways_D = remaining services after P
    //        = 1 + length of remaining sequence
    //        = 1 + {m - (i - 1)}
    //        = 1 + m - i + 1
    // ways_D = m + 2 - i
    
    // Thus, total possible ways for services for nth order would be:
    //  C(n) = C(n - 1) * Σ ways_Di
    
    // where ways_Di = ways to shedule ith Delivery 
    //               = m + 2 - i
    //  C(n) = C(n - 1) * Σ (m + 2 - i) for i in 1...ways_P
    //       = C(n - 1) * Σ (m + 2 - i) for i in 1...(m + 1 )
    //
    // Substituting j = m + 2 - i : 
    //  C(n) = C(n - 1) * Σj for j in (m + 1)...1
    //  C(n) = C(n - 1) * m * (m + 1) / 2
    
    //  C(n) = C(n - 1) * F(m)
    //  where F(m) = Σi for i in 1..m 
    //             = m * (m + 1) / 2
    //             = sum of first m natural numbers
    
    // for m = 2*n - 1
    // F(m) = F(2*n - 1) = Triangular series of nth odd number
    
    // C(n) = C(n - 1) * F(2* n - 1)
    // C(n) = Π F(i) for i in 1..n
    
    static final int MOD = 1000000007;
    
    private static final int triangle(int n){
        return n * (n + 1) / 2;        
    }
    
    public int countOrders(int n) {
        if(n == 1) return 1;
        
        return (int)((1L * triangle(2 * n - 1) * countOrders(n - 1)) % MOD);
    }
}