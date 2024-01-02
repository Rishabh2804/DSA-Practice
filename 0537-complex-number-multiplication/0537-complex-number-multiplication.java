class Solution {
    
    private static final int REAL = 0;
    private static final int IMG = 1;
    
    private int[] splitComplex(String num){
        int i = num.indexOf("+");
        
        int real = Integer.parseInt(num.substring(0, i));
        int img = Integer.parseInt(num.substring(i + 1, num.length() - 1));
        
        return new int[]{real, img};
    }
    
    public String complexNumberMultiply(String num1, String num2) {
        
        int[] a = splitComplex(num1);
        int[] b = splitComplex(num2);
        
        int real = a[REAL] * b[REAL] - a[IMG] * b[IMG];
        int img = a[REAL] * b[IMG] + a[IMG] * b[REAL];
        
        return real + "+" + img + "i";
    }
}