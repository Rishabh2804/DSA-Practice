class Solution {
    public int minReorder(int n, int[][] connections) {
        
        int count = 0;
        
        boolean[] visited = new boolean[n];
        ArrayList<Queue<int[]>> roads = new ArrayList<>();
        
        for(int i = 0; i < n; ++i)
            roads.add(new LinkedList<>());            
        
        for(int[] road : connections){
            roads.get(road[0]).add(new int[]{road[1], 1});  // 1 for out edge
            roads.get(road[1]).add(new int[]{road[0], -1}); //-1 for in edge
        }
        
        Queue<Integer> cities = new LinkedList<>();
        cities.add(0);
        
        while(!cities.isEmpty()){
            int size = cities.size();
            
            while(size --> 0){
                int curr = cities.poll();
                visited[curr] = true;
                
                Queue<int[]> neighbours = roads.get(curr);
                int neighbourCount = neighbours.size();
                
                while(neighbourCount --> 0){
                    int[] neighbour = neighbours.poll();
                    
                    if(!visited[neighbour[0]]){
                        cities.add(neighbour[0]);
                    
                        // if to-be-visited city is connected by outRoad
                        if(neighbour[1] == 1)
                            count++; // change to inRoad
                    }
                }
            }
        }
        
        return count;
    }
}