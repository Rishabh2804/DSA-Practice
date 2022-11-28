class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> players = new HashMap<>();
        
        for(int[] match : matches){
            int winner = match[0];
            int loser = match[1];
            
            if(!players.containsKey(winner))
                players.put(winner, 0);
            
            players.put(loser, players.getOrDefault(loser, 0) + 1);
        }
        
        List<List<Integer>> winners = new ArrayList<>();
        winners.add(new ArrayList<>());
        winners.add(new ArrayList<>());
        
        for(Integer player : players.keySet()){
            int losses = players.get(player);
            if(losses == 0)
                winners.get(0).add(player);
            else if(losses == 1)
                winners.get(1).add(player);
        }
        
        Collections.sort(winners.get(0));
        Collections.sort(winners.get(1));

        return winners;
    }
}