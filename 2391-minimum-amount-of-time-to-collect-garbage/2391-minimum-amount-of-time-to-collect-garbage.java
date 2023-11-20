class Solution {
    static final int PAPER = 0;
    static final int METAL = 1;
    static final int GLASS = 2;
    
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        
        int[] dest = new int[3];
        int[] time = new int[n];
        
        int totalTime = 0;
        for(int i = 0; i < n; ++i){
            totalTime += garbage[i].length();
            
            if(i > 0) time[i] = time[i - 1] + travel[i - 1];
            
            if(garbage[i].indexOf('P') != -1) dest[PAPER] = i;
            if(garbage[i].indexOf('M') != -1) dest[METAL] = i;
            if(garbage[i].indexOf('G') != -1) dest[GLASS] = i;            
        }
        
        totalTime += time[dest[PAPER]];
        totalTime += time[dest[METAL]];
        totalTime += time[dest[GLASS]];
        
        return totalTime;
    }
}