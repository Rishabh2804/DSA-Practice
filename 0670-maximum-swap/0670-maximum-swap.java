class Solution {
    
    private void print(int[] arr){
        for(int i : arr)
            System.out.print(i + " ");
        
        System.out.println();
    }
    
    private int[] getDigits(int num){
        int[] dig = new int[9];
        
        int pos = 0;
        while(num > 0){
            int curr = num % 10;
            num /= 10;
            
            dig[pos] = curr;
            pos++;
        }
        
        return dig;        
    } 
    
    private int[] getLast(int num){
        int[] map = new int[10];
        Arrays.fill(map, -1);
        
        int pos = 0;
        while(num > 0){
            int curr = num % 10;
            num /= 10;
            
            if(map[curr] == -1)
                map[curr] = pos;
            
            pos ++;  
        }
        
        return map;
    }
    
    public int maximumSwap(int num) {
        
        int[] dig = getDigits(num);
        
        int[] last = getLast(num);
        
        int pos = dig.length - 1;
        while(pos >= 0 && dig[pos] == 0) pos --;                
        
        int len = pos + 1;
        for(int i = pos; i >= 0; --i){
            int currDig = dig[i];
            
            boolean found = false;
            for(int j = 9; j > currDig; --j){
                if(last[j] == -1) continue;
                
                int idx = last[j];
                
                if(idx > i) continue;
                
                dig[i] = j;
                dig[idx] = currDig;
                
                found = true;
                break;
            }
            
            if(found) break;
        }
                
        int res = 0;
        for(int i = len; i >= 0; --i){            
            res *= 10;
            res += dig[i];
        }
        
        return res;
    }
}