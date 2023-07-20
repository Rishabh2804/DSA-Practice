class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> remaining = new Stack<>();
        for(int asteroid : asteroids){
            if(asteroid >= 0) remaining.push(asteroid);
            else{
                boolean flag = true;
                while(!remaining.isEmpty()){
                    int top = remaining.peek();
                    if(top < 0) break; // same direction
                    
                    int collision = top + asteroid;
                    
                    if(collision <= 0) 
                        remaining.pop();
                    
                    if(collision >= 0)  { // same size opposite direction
                        flag = false;
                        break;                       
                    }
                }
                
                // no asteroid in path
                // or asteroids in same direction
                if(flag) remaining.push(asteroid);
            }
        }
        
        int[] rem = new int[remaining.size()];
        for(int i = rem.length - 1; i >= 0; --i)
            rem[i] = remaining.pop();
        
        return rem;
    }
}