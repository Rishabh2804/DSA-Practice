class Solution {
    public String addBinary(String a, String b) {
        int resLen = Math.max(a.length(), b.length());
        char[] sum = new char[resLen];
        
        int carry = 0;
        for(int i = 0; i < resLen; ++i){
            int bit1 = 0, bit2 = 0;
            
            if(i < a.length())
                bit1 = a.charAt(a.length() - i - 1) - '0';

            if(i < b.length())
                bit2 = b.charAt(b.length() - i - 1) - '0';
            
            int tempSum = bit1 + bit2 + carry;
            carry = tempSum / 2;
            tempSum %= 2;
            
            sum[resLen - i - 1] = (char)('0' + tempSum);     
            System.out.println(tempSum + " " + carry + " " + bit1 + " " + bit2);
        }
                              
        if(carry == 1) return '1' + new String(sum);
        else return new String(sum);
    }
}