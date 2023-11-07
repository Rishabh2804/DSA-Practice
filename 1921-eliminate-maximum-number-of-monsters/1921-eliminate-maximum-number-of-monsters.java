class Solution {
    private int ceil(int a, int b){
        return (a + b - 1) / b;
    }
    
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;        
        Integer[] monsters = new Integer[n];
        for(int i = 0; i < n; ++i) 
            monsters[i] = i;
        
        Arrays.sort(monsters, (a, b) -> dist[a] * speed[b] - dist[b] * speed[a]);
        
        int eliminateCount = 0;
        int time = 0;
        for(Integer monster : monsters){
            int eta = ceil(dist[monster], speed[monster]);
            if(time >= eta) return eliminateCount;
            else {
                time++;
                eliminateCount++;
            }
        }
        
        return eliminateCount;
    }
}