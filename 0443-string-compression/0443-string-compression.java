class Solution {
    public int compress(char[] chars) {
        int length = 0;
        int count = 1;
        int idx = 0;
        
        char prev = chars[0];
        for(int i = 1; i < chars.length; ++i){
            if(chars[i] == prev){
                count ++;
                continue;
            } else{            
                chars[idx] = prev;             

                int digits = noOfDigits(count);
                int ei = idx + digits;
                while(ei > idx) {
                    chars[ei--] = (char)('0' + (count % 10));
                    count /= 10;
                }
                
                length += 1 + digits;
                idx = length;
                
                count = 1;    
                prev = chars[i];
            }                          
        }
        
        chars[idx] = prev;             

        int digits = noOfDigits(count);
        int ei = idx + digits;
        while(ei > idx) {
            chars[ei--] = (char)('0' + (count % 10));
            count /= 10;
        }

        length += 1 + digits;
        return length;
    }
    
    public int noOfDigits(int n){
        if(n <= 1)
            return 0;
        
        int count = 0;
        while(n > 0){
            n /= 10;
            count++;
        }
        
        return count;
    }
}