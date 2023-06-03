class Solution {
    static final int BOMB_ID = 0;
    static final int X = 1;
    static final int Y = 2;
    static final int RADIUS = 3;
    static final int IS_DETONATED = 4;
    
    public long getDistance(int x1, int y1, int x2, int y2){
        return 1L * (x1 - x2) * (x1 - x2) + 1L * (y1 - y2) * (y1 - y2);
    }
    
    public ArrayList<ArrayList<Integer>> getAdjList(int[][] bombInfo){        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < bombInfo.length; ++i)
            adj.add(new ArrayList<>());
        
        for(int i = 0; i < bombInfo.length; ++i){
            int[] bomb1 = bombInfo[i];
            for(int j = i + 1; j < bombInfo.length; ++j){
                int[] bomb2 = bombInfo[j];
                
                long dist = getDistance(bomb1[X], bomb1[Y], bomb2[X], bomb2[Y]);
                
                if(dist <= 1L * bomb1[RADIUS] * bomb1[RADIUS])
                    adj.get(bomb1[BOMB_ID]).add(bomb2[BOMB_ID]);
                
                if(dist <= 1L * bomb2[RADIUS] * bomb2[RADIUS])
                    adj.get(bomb2[BOMB_ID]).add(bomb1[BOMB_ID]);
            }
        }
        
        return adj;
    }
    
    int trigger_id = -1;
    public int detonate(int bombID, int[][] bombInfo, ArrayList<ArrayList<Integer>> adj){
        if(bombInfo[bombID][IS_DETONATED] == trigger_id) return 0;
        
        bombInfo[bombID][IS_DETONATED] = trigger_id;
        
        int count = 1;
        for(int bomb : adj.get(bombID)){
            count += detonate(bomb, bombInfo, adj);
        }
        
        // bombInfo[bombID][IS_DETONATED] = 0;

        return count;
    }
    
    public int maximumDetonation(int[][] bombs) {
        trigger_id = -1;
        
        int[][] bombInfo = new int[bombs.length][5];
        for(int i = 0; i < bombs.length; ++i){
            bombInfo[i][BOMB_ID] = i;
            bombInfo[i][X] = bombs[i][0];
            bombInfo[i][Y] = bombs[i][1];
            bombInfo[i][RADIUS] = bombs[i][2];
            bombInfo[i][IS_DETONATED] = trigger_id;
        }
        
        ArrayList<ArrayList<Integer>> adj = getAdjList(bombInfo);
        int count = 0;
        for(int i = 0; i < bombs.length; ++i){
            trigger_id = i;
            count = Math.max(count, detonate(i, bombInfo, adj));
        }
        return count;
    }
}