class Solution {
    public int minReorder(int n, int[][] connections) {
        
        int count = 0;
        
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> inRoads = new ArrayList<>();
        ArrayList<ArrayList<Integer>> outRoads = new ArrayList<>();
        
        for(int i = 0; i < n; ++i){
            inRoads.add(new ArrayList<>());
            outRoads.add(new ArrayList<>());
        }
        
        for(int[] road : connections){
            inRoads.get(road[1]).add(road[0]);
            outRoads.get(road[0]).add(road[1]);
        }
        
        Queue<Integer> cities = new LinkedList<>();
        cities.add(0);
        
        while(!cities.isEmpty()){
            int size = cities.size();
            
            while(size --> 0){
                int curr = cities.poll();
                visited[curr] = true;
                
                for(int city : outRoads.get(curr)){
                    if (!visited[city]){
                        count++;
                        inRoads.get(curr).add(city);
                    }                    
                }
                
                for(int city : inRoads.get(curr)){
                    if(!visited[city])
                        cities.add(city);    
                }
            }
        }
        
        return count;
    }
}