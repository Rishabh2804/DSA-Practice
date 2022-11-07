class Solution {        
        
    public int maximum69Number (int num) {
        
        int maxLen = 10000;
        while(maxLen > 0){
            int digit = num % maxLen;
            maxLen /= 10;
            
            if(maxLen != 0)
                digit /= maxLen;
            
            if(digit == 6){
                num += 3 * maxLen;
                break;
            }
        }
        
        return num;
    }
}