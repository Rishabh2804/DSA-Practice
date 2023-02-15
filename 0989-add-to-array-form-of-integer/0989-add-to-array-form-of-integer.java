class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> sum = new ArrayList<>();
        
        int carry = 0;
        for(int i = num.length - 1; i >= 0; --i){
            int dig1 = k % 10;
            k /= 10;
            
            int dig2 = num[i];
            int tempSum = dig1 + dig2 + carry;
            carry = tempSum / 10;
            
            sum.add(tempSum % 10);
        }
        
        while(k > 0){
            int dig1 = k % 10;
            k /= 10;
            
            int tempSum = dig1 + carry;
            carry = tempSum / 10;
            sum.add(tempSum % 10);
        }
        
        if(carry != 0)
            sum.add(carry);
        
        Collections.reverse(sum);
        return sum;
    }
}