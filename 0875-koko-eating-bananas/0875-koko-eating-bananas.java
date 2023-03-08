class Solution {
    
    public int ceil(int a, int b){
        return (a + b - 1) / b;    
    }
    
    public int minEatingSpeed(int[] piles, int h) {    
        int n = piles.length;
        
        int minSpeed = 1;
        int maxSpeed = Integer.MIN_VALUE;
        
        for(int pile : piles)
            maxSpeed = Math.max(maxSpeed, pile);        
        
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
}