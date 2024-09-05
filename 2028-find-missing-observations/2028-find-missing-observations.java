class Solution {
    
    private static final int[] NONE = new int[0];
    
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int total = mean * (n + m);
        
        for(int i : rolls) total -= i;
        total -= n; // min value of every die face is 1
        
        if(total > 5 * n || total < 0) return NONE;
        
        int[] missing = new int[n];
        Arrays.fill(missing, 1);        
        
        for(int i = 0; i < n; ++i){
            if(total < 5){
                missing[i] += total;
                total = 0;
                break;
            } 
            
            missing[i] += 5;
            total -= 5;
        }
        
        
        return missing;
    }
}