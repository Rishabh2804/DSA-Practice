class Solution {
    public int bestClosingTime(String customers) {
        
        int n = customers.length();
        
        int totalVisHours = 0;
        for(int i = 0; i < n; ++i){
            if(customers.charAt(i) == 'Y')
                totalVisHours ++;
        }
        
        int hour = 0;
        int minPenalty = totalVisHours; // at 0th hour
        
        int currVisHours = 0;
        for(int i = 0; i < n; ++i){
            if(customers.charAt(i) == 'Y')
                currVisHours ++;
            
            int postCloseVis = totalVisHours - currVisHours;
            int currCloseIdle = i - currVisHours + 1;
            
            int currPenalty = currCloseIdle + postCloseVis;
            
            if(currPenalty < minPenalty){
                minPenalty = currPenalty;
                hour = i + 1;
            }
        }

        return hour;
    }
}