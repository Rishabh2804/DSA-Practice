class Solution {
    
    // Let the size of input arr be n
    // Given that there is exactly one integer with freq > n / 4, 
    // and the array is sorted, it must be present along a range overlapping 
    // atleast two quarter ranges.
    
    // E.g. : [a1 a2 ... x elements] [b1 b2 ... x elements] [c1 c2 ... x elements] [d1 d2 ... x elements] 
    // For an answer to exist, say y, 
    // y == ai == bi+x or
    // y == bi == ci+x or
    // y == ci == di+x    
    
    
    // If we further partition these segments into 8, y must cover atleast 1 of an octet.
    // We can verify our answer by checking the extreme ends of each octet
    
    // E.g. : 
    // [a1 a2 ... x/2 elements] [b1 b2 ... x/2 elements] [c1 c2 ... x elements] [d1 d2 ... x elements] 
    // [e1 e2 ... x/2 elements] [f1 f2 ... x/2 elements] [g1 g2 ... x elements] [h1 h2 ... x elements]     
    
    // y == 
    //  a1 == ax+1
    //  b1 == bx+1
    //  c1 == cx+1
    //  d1 == dx+1
    //  e1 == ex+1
    //  f1 == fx+1
    //  g1 == gx+1
    //  h1 == hx+1
    
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int qLen = 1 + (n / 4);
        
        int count = 1;
        for(int i = 1; i < n; ++i){
            if(arr[i] == arr[i - 1]) count ++;
            else count = 1;
            
            if(count >= qLen) return arr[i];
        }
                
        return arr[0];
    }
}