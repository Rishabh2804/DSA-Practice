class Solution {
    
    private int ceil(int a, int b){
        return (a + b - 1) / b;
    }

    public double calculateTime(int speed, int[] dist){
        double time = 0.0;
        
        for(int i = 0; i < dist.length - 1; ++i)
            time += ceil(dist[i], speed);

        return time + (double)dist[dist.length - 1] / speed;
    }
    
    public int minSpeedOnTime(int[] dist, double hour) {        
        if(hour + 1 < dist.length) return -1;
        
        int l = 1;
        int r = Integer.MAX_VALUE;
//         for(int d : dist) r = Math.max(r, d);        
//         r += 1;
        
        boolean onTime = false;
        while(l < r){
            int mid = l + (r - l) / 2;
            double timeTaken = calculateTime(mid, dist);
            
            if(timeTaken <= hour) {
                r = mid;
                onTime = true;
            } else l = mid + 1;
        }

        return (onTime) ? l : -1;
    }
}