class Solution {
    public int preimageSizeFZF(int k) {
        return check2(k) ? 5 : 0;
    }
    
    public boolean check(int k){
        
        k ++;
        
        int mult = 6;
        int rem = k % mult;
        k /= mult;
        
        while(k > 0 && rem >= 0){
            mult = 5 * mult + 1;
            
            k /= 5;
            
            rem -= k;
        }
        
        return rem == 0;
    }
    
    public boolean check2(int k){
        long si = 0, ei = (long) k * 5L;
        while(si <= ei){
            long mid = (si + ei + 1) / 2;
            long zeroes = getTrailingZeroes(mid);
            if(zeroes == k)
                return true;
            else if(zeroes < k)
                si = mid + 1;
            else
                ei = mid - 1;                
        }
        
        return false;
    }
    
    public long getTrailingZeroes(long n){
        long count = 0;
         
        while(n > 0){
            count += n / 5L;
            n /= 5L;
        }
        
        return count;
    }
}

// 1*161 -> 6*26 + 5 -> 6*1 + 31*5 + 0
// 1*172 -> 6*27 + 5 -> 6*2 + 31*5 + 0
// 1*185 -> 6*30 + 5 -> 31*6 - 1
// 1*191 -> 6*31 + 5 -> 6*6 + 31*5 + 0
// 1*192 -> 6*32 + 0 -> 6*2 + 31*6 - 6
// 1*193 -> 6*32 + 1 -> 31*6 + 13 - 6 = 31*6 + 7 ->  155*1 + 31 + 7 - 1 = 155*1 + 37

// 0-4 -> 0
// 5-9 -> 1
// 10-14 ->2

// 20-24 ->4
// 25-29 -> 6


// -1, 5, 11, 17, 23, 29, 30, 36, 42, 48, 54, 60, 61, 62

// 61 
// m n p

// m = 61 / 6 = 10 > 5
// n = m / 5 = 2
// p = n / 5 = 0
// n -= p => n = 2
// m -= n => m = 8

// k = -1 + 6*m + 7*n + 8*p .....
// k = -1 + 6*8 + 7*2 +


// 120 -> 120/5 + 120/25 = 24 + 4 = 28
// 125 -> 125/5 + 120/25 + 125/125 = 25 + 5 + 1 = 31