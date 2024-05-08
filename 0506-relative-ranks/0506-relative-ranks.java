class Solution {
    
    private static final String GOLD = "Gold Medal";
    private static final String SILVER = "Silver Medal";
    private static final String BRONZE = "Bronze Medal";
    
    public String[] findRelativeRanks(int[] score) {
        
        int n = score.length;
        String[] ranks = new String[n];
        PriorityQueue<Integer> top = new PriorityQueue<>((a, b) -> score[a] - score[b]);
        
        for(int i = 0; i < n; ++i){
            top.add(i);
        }
        
        
        while(!top.isEmpty()){
            int currRank = top.size();
            int curr = top.poll();
            
            if(currRank == 1) ranks[curr] = GOLD;
            else if(currRank == 2) ranks[curr] = SILVER;
            else if(currRank == 3) ranks[curr] = BRONZE;
            else ranks[curr] = "" + currRank;
        }
        
        return ranks;
    }
}