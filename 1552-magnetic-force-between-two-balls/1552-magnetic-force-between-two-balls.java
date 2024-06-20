class Solution {
    
    private boolean check(int[] pos, int m, int dis){
        int si = pos[0];
        for(int i = 1; i < pos.length; ++i){
            if(pos[i] - si >= dis){
                si = pos[i];
                m--;
            }
            
            if(m <= 1) return true;
        }
        
        // System.out.println(dis + " " + m);
        return false;
    }
    
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        int l = 1, r = position[position.length - 1] - position[0];
        while(l < r){
            int mid = (l + r + 1) / 2;
            if(check(position, m, mid)) l = mid;
            else r = mid - 1;
        }
        
        return l;
    }
}