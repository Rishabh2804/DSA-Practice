class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        
        int dy = coordinates[1][1] - y0;
        int dx = coordinates[1][0] - x0;
        
        for(int i = 2; i < coordinates.length; ++i){
            int dy1 = coordinates[i][1] - y0;
            int dx1 = coordinates[i][0] - x0;
            
            if(dy1 * dx != dy * dx1) return false;
        }
        
        return true;
    }
}