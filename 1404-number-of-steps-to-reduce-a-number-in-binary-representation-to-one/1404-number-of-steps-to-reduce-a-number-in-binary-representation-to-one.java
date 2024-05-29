class Solution {
    
    private int count1(int n){
        // if(n == 0 || n == 1) return 0;
        // else 
            return n + 1;
    }
    
    public int count0(int n){
        return 2 * n;
    }
        
    public int numSteps(String s) {
        
        int n = s.length();
        
        char[] arr = s.toCharArray();
        int ans = 0;
        
        int ei = n - 1;
        int si = 0;
        while(ei > si){
            
            if(arr[ei] == '0') {
                ans ++;
                ei--;
            }
            else {
                while(ei >= 0 && arr[ei] == '1') {
                    ans ++;
                    ei--;
                }
                
                ans++;
                
                if(ei >= 0)
                arr[ei] = '1';                
            }
            
        }
//         System.out.println(ones);
        
//         ans += count1(ones);
            
        return ans;
    }
}

// 111100011110010

// 4 4 3

// 4 4 1


// 10011100000
// 100111
// 101000
// 101

// 101
// 11
// 1

// 111

// 1011001
// 1  // 1011010
// 2  // 101101
// 3  // 101110
// 4  // 10111
// 5  // 11000
// 6  // 1100
// 7  // 110
// 8  // 11
// 9  // 100
// 10 // 10
// 11 // 1