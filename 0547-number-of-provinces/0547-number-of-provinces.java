class Solution {
    
    public void traverse(int i, int[][] isConnected, boolean[] visited){
        if(visited[i]) return;
        
        visited[i] = true;
        for(int city = 0; city < isConnected.length; ++city){
            if(isConnected[i][city] == 1) 
                traverse(city, isConnected, visited);
        }        
    }
    
    public int findCircleNum(int[][] isConnected) {
        
        boolean[] visited = new boolean[isConnected.length];
        
        int provinces = 0;
        for(int city = 0; city < isConnected.length; ++city){
            if(!visited[city]){
                provinces++;
                traverse(city, isConnected, visited);
            }
        }
        
        return provinces;
    }
}