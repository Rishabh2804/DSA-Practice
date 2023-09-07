class Solution {
    
    private int getInfo(int empID, int[] manager, int[] informTime, Integer[] time){
        
        if(time[empID] != null) return time[empID];
        
        if(manager[empID] == -1) return time[empID] = 0;
        
        int mngr = manager[empID];
        return time[empID] = informTime[mngr] + getInfo(mngr, manager, informTime, time);
    }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        Integer[] time = new Integer[n];
        int minutes = 0;
        for(int i = 0; i < n; ++i){
            if(time[i] == null)
                getInfo(i, manager, informTime, time);
            
            minutes = Math.max(minutes, time[i]);
        }
        
        return minutes;
    }
}