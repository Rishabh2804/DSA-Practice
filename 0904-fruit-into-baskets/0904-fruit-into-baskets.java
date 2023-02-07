class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length <= 2)
            return fruits.length;
    
        int si = 0;
        int cons = 1;
        int maxLength = 2;
        
        int a = 0, b = 1;
        if(fruits[0] == fruits[1]){
            b = a;
            cons = si;
        }
            
        for(int i = 2; i < fruits.length; ++i) {
            if(fruits[i] != fruits[si] && fruits[i] != fruits[b]){
                int length = i - si;
                maxLength = Math.max(maxLength, length);
                
                a = b;
                b = i;
                si = cons;                                
            }             
            
            if(fruits[i] != fruits[cons])
                cons = i;
        }
        
        return maxLength = Math.max(maxLength, fruits.length - si);        
    }
}