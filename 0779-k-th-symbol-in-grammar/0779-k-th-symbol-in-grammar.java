class Solution {
    
    private int solve(int n, int k){
        if(n == 0) return 0;
        
        int len = 1 << (n - 1);
        
        if(k < len) return solve(n - 1, k);
        else return 1 - solve(n - 1, k % len);
    }
    
    public int kthGrammar(int n, int k) {
        
        // for 0-indexed solution
        return solve(n - 1, k - 1);    
    }
}

// 0
// 01
// 0110
// 01101001
// 01101001 10010110

// Let the pattern formed in nth row be given by P(n)
// 0 --> 01 
// 1 --> 10
// ==> A --> AA`

// Thus, P(n) = P(n - 1) P`(n - 1)
//            = P(n - 1) (P(n - 2) P`(n - 2))`
//            = P(n - 1) P`(n - 2) P(n - 2)

// Let the length of nth row be L(n)
//  => L(n) = 2 ^ n

// Let the character found in kth pos of nth row be C(n, k)
// If k <= L(n) / 2 = L(n - 1), 
//          C(n, k) = C(n - 1, k)
// else     C(n, k) = C`(n - 1, k1) 
//                  = 1 - C(n - 1, k1)
// 
// where         k1 = k % L(n - 1)