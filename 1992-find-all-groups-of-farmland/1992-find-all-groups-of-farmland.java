class Solution {
    
    private static final int VIS = -1;
    private static final int FOREST = 0;    
    private static final int FARM = 1;
    
    private void markVisited(int si, int sj, int ei, int ej, int[][] land){
        for(int i = si; i <= ei; ++i){
            for(int j = sj; j <= ej; ++j)
                land[i][j] = VIS;
        }
    }
    
    private int[] getFarmPos(int si, int sj, int[][] land){
        
        int n = land.length;
        int m = land[0].length;
        
        int ei = si;
        int ej = sj;
        
        while(ei < n && land[ei][ej] == FARM) ei++;
        ei --;
        
        while(ej < m && land[ei][ej] == FARM) ej ++;
        ej --;
        
        markVisited(si, sj, ei, ej, land);
        
        return new int[]{si, sj, ei, ej};
    }
    
    public int[][] findFarmland(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        
        ArrayList<int[]> farms = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(land[i][j] == FARM) {
                    int[] farmCoord = getFarmPos(i, j, land);
                    farms.add(farmCoord);
                }
            }
        }
                
        int[][] farmLands = new int[farms.size()][4];
        for(int i = 0; i < farms.size(); ++i)
            farmLands[i] = farms.get(i);
        
        return farmLands;
    }
}