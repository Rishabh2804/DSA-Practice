class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
                
        int boats = 0;
        int currLimit = limit;
        
        int si = 0, ei = people.length - 1;
        while(si <= ei){
            boats++;
            
            if(people[si] + people[ei] <= limit){
                si ++;
                ei --;
            } else
                ei--;            
            
        }
       
        return boats;
    }
}