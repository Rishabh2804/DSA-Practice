class Solution {
    public int bestClosingTime(String customers) {
        
        int n = customers.length();
        
        int totalVisHours = 0;
        for(int i = 0; i < n; ++i){
            if(customers.charAt(i) == 'Y')
                totalVisHours ++;
        }
        
        int hour = 0;
        
        int postCloseVis = totalVisHours;
        int currCloseIdle = 0;

        // at 0th hour
        int minPenalty = totalVisHours; // same as currCloseIdle + postCloseVis
        
        for(int i = 0; i < n; ++i){
            if(customers.charAt(i) == 'Y')
                postCloseVis --;
            else
                currCloseIdle ++;
            
            int currPenalty = currCloseIdle + postCloseVis;
            
            if(currPenalty < minPenalty){
                minPenalty = currPenalty;
                hour = i + 1;
            }
        }

        return hour;
    }
}