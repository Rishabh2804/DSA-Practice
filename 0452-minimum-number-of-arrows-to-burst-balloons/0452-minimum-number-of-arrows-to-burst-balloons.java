class Solution {
    public int findMinArrowShots(int[][] points) {
        
        int n = points.length;
        
        Arrays.sort(points, (a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            else return a[0] - b[0];
        });
        
        int count = 1;
        int si = points[0][0];
        int ei = points[0][1];
        for(int[] balloon : points){
            int start = balloon[0];
            int end = balloon[1];

            if(end < si || start > ei) {
                si = start;
                ei = end;
                count ++;
            } else {
                si = Math.max(si, start);
                ei = Math.min(ei, end);
            }            
        }

        return count;
    }
}