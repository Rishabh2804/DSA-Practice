class Solution {
    
    static final int BASE = 10000;
    
    public boolean isPathCrossing(String path) {
        int vertical = 0;
        int horizon = 0;
        
        int currPos = BASE*vertical + horizon;
        HashSet<Integer> coords = new HashSet<>();
        coords.add(currPos);
        
        for(int i = 0; i < path.length(); ++i){
            switch(path.charAt(i)){
                case 'N' : vertical++; 
                           break;
                case 'E' : horizon++; 
                           break;
                case 'S' : vertical--; 
                           break;
                case 'W' : horizon--; 
                           break;
                default  : break;                
            }
            
            currPos = BASE*vertical + horizon;
            if(coords.contains(currPos)) return true;
            
            coords.add(currPos);
        }
        
        return false;
    }
}