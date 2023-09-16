class Solution {
    
    static final int X = 0;
    static final int Y = 1;
    static final int EFFORT = 2;

    static final int INF = 1000001; // heights[i][j] ∈ {1, 1e6}
    
    static final int[] xDir = {-1,  0, 0, 1};
    static final int[] yDir = { 0, -1, 1, 0};
    
    public int minimumEffortPath(int[][] heights) {
        
        int n = heights.length;
        int m = heights[0].length;
        
        int[][] effort = new int[n][m];
        for(int[] row : effort)
            Arrays.fill(row, INF);
        
        effort[0][0] = 0;
        
        PriorityQueue<int[]> cells = new PriorityQueue<>((a, b) -> effort[a[X]][a[Y]] - effort[b[X]][b[Y]]);
        cells.add(new int[]{0, 0});
        
        while(!cells.isEmpty()){
            int[] currCell = cells.poll();
            
            int currX = currCell[X];
            int currY = currCell[Y];
            int currEffort = effort[currX][currY];
            
            for(int dir = 0; dir < 4; ++dir){
                int x = currX + xDir[dir];
                int y = currY + yDir[dir];

                if(x >= 0 && x < n && y >= 0 && y < m){
                    int diff = Math.abs(heights[currX][currY] - heights[x][y]);
                    int postEffort = Math.max(currEffort, diff);
                    
                    if(postEffort < effort[x][y]) {
                        effort[x][y] = postEffort;
                        cells.add(new int[]{x, y});
                    }
                }
            } 
        }
        
        return effort[n - 1][m - 1];
    }
}