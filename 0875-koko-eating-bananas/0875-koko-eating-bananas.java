class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int n = piles.length;
        int minSpeed = Integer.MAX_VALUE;
        int maxSpeed = Integer.MIN_VALUE;
        
        for(int pile : piles){
         //   minSpeed = Math.min(minSpeed, pile);
            maxSpeed = Math.max(maxSpeed, pile);
        }
        
        minSpeed = 1;
        maxSpeed *= ceil(n, h);
        
        while(minSpeed < maxSpeed){
            int mid = (minSpeed + maxSpeed) / 2;
            int hours = 0;
            for(int bananas : piles)
                hours += ceil(bananas, mid);
            
            if(hours <= h)
                maxSpeed = mid;
            else
                minSpeed = mid + 1;
        }
        
        return minSpeed;
    }
    
    public int ceil(int a, int b){
        return (a + b - 1) / b;    
    }
}