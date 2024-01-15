class Solution {
    
    static final int OUT = 0;
    static final int WIN_1 = 1;
    static final int WIN_ALL = 2;
    
    // state change for every: 
    // - win :   s -> s * 1
    // - loss:   s -> s / 2
    
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> playerRecords = new HashMap<>();
        for(int[] match : matches){
            
            int w = match[0];
            int l = match[1];
            
            playerRecords.putIfAbsent(w, WIN_ALL);
            playerRecords.putIfAbsent(l, WIN_ALL);
            
            // no change
            // playerRecords.put(w, playerRecords.get(w)); 
            
            playerRecords.put(l, playerRecords.get(l) / 2); // lose one {2 -> 1 -> 0}
        }
        
        List<List<Integer>> winners = new ArrayList<>();
        
        List<Integer> win_all = new ArrayList<>();
        List<Integer> win_1 = new ArrayList<>();
        
        for(Integer player : playerRecords.keySet()){
            Integer playerRecord = playerRecords.get(player);
            if(playerRecord == WIN_ALL) win_all.add(player);
            else if(playerRecord == WIN_1) win_1.add(player);
        }
        
        Collections.sort(win_all);
        Collections.sort(win_1);
        
        winners.add(win_all);
        winners.add(win_1);
        
        return winners;
    }
}