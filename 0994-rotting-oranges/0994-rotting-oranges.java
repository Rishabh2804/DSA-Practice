class Solution {
    static final int EMPTY = 0;
    static final int FRESH = 1;
    static final int ROTTEN = 2;
    
    static final int[] xDir = {-1, 0,  0, 1};
    static final int[] yDir = { 0, 1, -1, 0};
    
    public int orangesRotting(int[][] grid) {
        
        int freshOranges = 0;
        Queue<int[]> rottenOranges = new LinkedList<>();
        
        for(int row = 0; row < grid.length; ++row){
            for(int col = 0; col < grid[0].length; ++col){
                if(grid[row][col] == FRESH) freshOranges++;
                else if(grid[row][col] == ROTTEN) {
                    rottenOranges.add(new int[]{row, col});
                    grid[row][col] = EMPTY; // remove that orange to avoid redundant calls
                }
            }
        }
        
        int minutes = 0;
        while(!rottenOranges.isEmpty() && freshOranges > 0){
            
            int rottenCount = rottenOranges.size();
            
            while(rottenCount --> 0 && freshOranges > 0){
                
                int[] coords = rottenOranges.poll();
                
                for(int dir = 0; dir < 4; ++dir){
                    int x = coords[0] + xDir[dir];
                    int y = coords[1] + yDir[dir];

                    if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
                        continue;

                    if(grid[x][y] == EMPTY)
                        continue;

                    rottenOranges.add(new int[]{x, y});
                    grid[x][y] = EMPTY;
                    freshOranges--;                        
                }
                
                System.out.println(coords[0] + " " + coords[1] + " " + minutes + " " + freshOranges);
            }
            
            minutes++;
        }
        
        if(freshOranges != 0) return -1;
        else return minutes;
    }
}