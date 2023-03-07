class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int n = time.length;
                
        long minTime = time[0];
        long maxTime = time[0];
        
        for(int t : time){
            minTime = Math.min(minTime, t);
            maxTime = Math.max(maxTime, t);
        }
        
        maxTime *= totalTrips;
        
        while(minTime < maxTime){
            long mid = (maxTime + minTime) / 2;
            
            long trips = 0;
            for(int t : time)
                trips += mid / t;
            
            if(trips >= totalTrips)
                maxTime = mid;
            else
                minTime = mid + 1;
            
            System.out.println(minTime + " "  + maxTime);
        }
        
        return minTime;
    }
}