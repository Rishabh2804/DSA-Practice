class Solution {
    public int minimumRounds(int[] tasks) {
        
        HashMap<Integer, Integer> difficulties = new HashMap<>(); 
        for(int task : tasks)
            difficulties.put(task, difficulties.getOrDefault(task, 0) + 1);
        
        int rounds = 0;
        for(int count : difficulties.values()){
            if(count <= 1)
                return -1;
            
            rounds += count / 3;
            if(count % 3 != 0)
                rounds++;
        }
        
        return rounds;
    }
}