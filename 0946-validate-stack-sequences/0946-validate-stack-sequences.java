class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {        
        int i = -1, j = 0;
        for(int ele : pushed){                        
            pushed[++i] = ele;
            
            while(i >= 0 && j < popped.length && pushed[i] == popped[j]){
                i--;
                j++;
            }

        }

        return i < 0;
    }
}