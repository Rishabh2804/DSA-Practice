class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        
        if(points.length == 0) return 0;
        
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        
        int count = 1;
        int si = points[0][0];
        for(int[] point : points){
            if(point[0] - si > w){
                count ++;
                si = point[0];
            }
        }
        
        return count;
    }
}