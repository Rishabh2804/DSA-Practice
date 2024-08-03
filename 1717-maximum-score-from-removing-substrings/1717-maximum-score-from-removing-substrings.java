class Solution {
    
    private static final char SKIP = '*';
    private static final char[] SUB_X = {'a', 'b'};
    private static final char[] SUB_Y = {'b', 'a'};
    
    private int rem(char[] arr, char[] sub, int point){
        Stack<Integer> stack = new Stack<>();
        
        int total = 0;
        for(int i = 0; i < arr.length; ++i){
            if(arr[i] == SKIP) continue;
            
            if(!stack.isEmpty() && arr[stack.peek()] == sub[0] && arr[i] == sub[1]){
                total += point;
                
                arr[stack.peek()] = SKIP;
                arr[i] = SKIP;
                
                stack.pop();                
            } else stack.add(i);  
        }
        
        return total;
    }
    
    public int maximumGain(String s, int x, int y) {
        
        char[] arr = s.toCharArray();
        
        int point1 = 0;
        int point2 = 0;
        
        if(x >= y) {
            point1 = rem(arr, SUB_X, x);
            point2 = rem(arr, SUB_Y, y);
        } else {
            point2 = rem(arr, SUB_Y, y);
            point1 = rem(arr, SUB_X, x);
        }
        
        return point1 + point2;
    }
}