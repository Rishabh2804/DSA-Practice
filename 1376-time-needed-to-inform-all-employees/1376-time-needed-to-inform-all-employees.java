class Solution {
    
    public void inform(int managerID, ArrayList<ArrayList<Integer>> subordinates, int[] time, int[] informTime){
        
        for(int employee : subordinates.get(managerID)){
            time[employee] = time[managerID] + informTime[managerID];
            inform(employee, subordinates, time, informTime);
        }
    }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> subordinates = new ArrayList<>();
        for(int i = 0; i < n; ++i) subordinates.add(new ArrayList<>());
        
        for(int i = 0; i < n; ++i){
            if(manager[i] == -1) 
                continue;      
            
            subordinates.get(manager[i]).add(i);
        }
        
        int[] time = new int[n];
        Arrays.fill(time, -1);
        time[headID] = 0;
        
        inform(headID, subordinates, time, informTime);
        
        int minutes = 0;
        for(int t : time)
            minutes = Math.max(minutes, t);
            
        return minutes;
    }
}