class Solution {
    private int ceil(int a, int b){
        return (a + b - 1) / b;
    }
    
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;        
        for(int i = 0; i < n; ++i)
            dist[i] = ceil(dist[i], speed[i]);
        
        Arrays.sort(dist);
        
        int time = 0;
        for(int eta : dist){
            if(time >= eta) return time;
            else time++;
        }
        
        return time;
    }
}