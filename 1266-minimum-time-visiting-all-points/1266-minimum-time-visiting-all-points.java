class Solution {
    private static final int X = 0;
    private static final int Y = 1;
    
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;
        
        int currX = points[0][X];
        int currY = points[0][Y];
        
        for(int[] point : points){
            int dx = Math.abs(point[X] - currX);
            int dy = Math.abs(point[Y] - currY);
            
            totalTime += Math.max(dx, dy);
            
            currX = point[X];
            currY = point[Y];            
        }
        
        return totalTime;
    }
}