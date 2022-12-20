class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        boolean[] unlocked = new boolean[rooms.size()];
        visit(0, rooms, unlocked);
        
        return allVisited(unlocked);
    }
    
    public void visit(int i, List<List<Integer>> rooms, boolean[] unlocked){
        if(unlocked[i])
            return;
        
        unlocked[i] = true;
        for(int room : rooms.get(i))
            visit(room, rooms, unlocked);                
        
    }
    
    public boolean allVisited(boolean[] rooms){
        boolean res = true;
        for(boolean isVisited : rooms)
            res &= isVisited;
        
        return res;
    }
}