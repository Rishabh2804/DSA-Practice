class Solution {
    
    private int[] convert(String s){
        int[] num = new int[2 * s.length()];
        for(int i = 0, j = 0; j < s.length(); ++i, ++j){
            int curr = s.charAt(j) - 'a' + 1;
            if(curr < 10) num[i] = curr;
            else {
                num[i] = curr / 10;
                num[i + 1] = curr % 10;
                i++;
            }
        }
        
        return num;
    }
    
    private void print(int[] arr){
        for(int i : arr)
            System.out.print(i + " ");
        
        System.out.println();
    }
    
    private int[] transform(int[] num){
        print(num);
        int sum = 0;
        for(int i : num) sum += i;
        System.out.println(sum);
        
        return toArr(sum);
    }
    
    private int[] toArr(int n){
        int[] num = new int[4];
        
        for(int i = 3; i >= 0; --i){
            num[i] = n % 10;
            n /= 10;
        }
        
        return num;
    }
    
    private int toInt(int[] arr){
        int n = 0;
        for(int i : arr){
            n *= 10;
            n += i;
        }
        
        return n;
    }
    
    public int getLucky(String s, int k) {
        int[] num = convert(s);
                
        while(k --> 0)
            num = transform(num);
        
        return toInt(num);
    }
}