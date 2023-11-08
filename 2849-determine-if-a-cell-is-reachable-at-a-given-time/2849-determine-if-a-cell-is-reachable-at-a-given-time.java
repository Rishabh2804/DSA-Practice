class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(sx == fx && sy == fy) return t != 1;
        
        int xDis = Math.abs(fx - sx);
        int yDis = Math.abs(fy - sy);
        
        return t >= Math.max(xDis, yDis);
    }
}