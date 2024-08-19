class Solution {
    
    private static final int[] steps;
    private static final int SIZE = 1000;
    
    static {
        steps = new int[SIZE + 1];
        steps[1] = 0;
        
        for(int i = 2; i <= SIZE; ++i){
            if(steps[i] == 0) steps[i] = i;
            
            int curr = 2 * i;
            for(int j = 2; curr <= SIZE; ++j) {
                int currSteps = steps[i] + j;
                
                if(steps[curr] == 0) 
                    steps[curr] = currSteps;
                else
                    steps[curr] = Math.min(steps[curr], currSteps);
                
                curr += i;
            }            
        }           
    }
    
    public int minSteps(int n) {
        return steps[n];
    }
}