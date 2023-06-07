class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while(a != 0 || b != 0 || c != 0){
            int dig1 = a & 1;
            int dig2 = b & 1;
            int dig3 = c & 1;
            
            if(dig3 == 0)
                count += dig1 + dig2;
            else
                count += (3 - (dig1 + dig2)) / 3;
            
            a /= 2;
            b /= 2;
            c /= 2;
        }
        
        return count;
    }
}