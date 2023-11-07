class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;        
        Integer[] monsters = new Integer[n];
        for(int i = 0; i < n; ++i) 
            monsters[i] = i;
        
        Arrays.sort(monsters, (a, b) -> dist[a] * speed[b] - dist[b] * speed[a]);
        
        int time = 0;
        for(Integer monster : monsters){
            int eta = (dist[monster] + speed[monster] - 1) /  speed[monster];
            if(time >= eta) return time;
            else time++;
        }
        
        return time;
    }
}