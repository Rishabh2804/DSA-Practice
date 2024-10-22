class Solution {
    
    class DigiInfo {
        int[] digits;
        int[] last;
        
        private static final int SIZE = 9;
        
        public DigiInfo(int num){            
            run(num);
        }
        
        private void run(int num){    
            this.digits = new int[SIZE];
            this.last = new int[10];
            Arrays.fill(last, -1);
            
            int pos = 0;
            while(num > 0){
                int curr = num % 10;
                num /= 10;

                digits[pos] = curr;
                if(last[curr] == -1)
                    last[curr] = pos;
            
                pos++;
            }
        }    
    }
    
    private void print(int[] arr){
        for(int i : arr)
            System.out.print(i + " ");
        
        System.out.println();
    }
    
    public int maximumSwap(int num) {
        
        DigiInfo info = new DigiInfo(num);
        
        int[] dig = info.digits;        
        int[] last = info.last;
        
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