class Solution {
    public boolean isPowerOfFour(int n) {
        int count = 0;
        boolean flag = false;
        
        while(n > 0){
            if(n % 2 == 1){
                if(flag)
                    return false;
                else
                    flag = true;
            }
            
            count++;
            n >>= 1;
        }
        
        return flag && (count % 2 == 1);
    }
}