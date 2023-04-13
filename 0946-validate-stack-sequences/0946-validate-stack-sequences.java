class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> checked = new Stack<>();
        
        int i = 0, j = 0;
        while(i < pushed.length){                        
            checked.push(pushed[i++]);
            
            while(!checked.isEmpty() && j < popped.length && checked.peek() == popped[j]){
                checked.pop();
                j++;
            }
                
        }

        // while(!checked.isEmpty() && j < popped.length){
        //     if (checked.pop() != popped[j++])
        //         return false;
        // }

        return checked.isEmpty();
    }
}