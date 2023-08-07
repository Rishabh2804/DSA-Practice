class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while(i < bits.length - 1){
            i += 1 + bits[i];
        }
        
        return i == bits.length - 1;
    }
}