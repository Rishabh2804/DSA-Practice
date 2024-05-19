class Solution {
    
    private static final int INF = 10000;
    private static final int[][] dirs = {
        {-1, 0}, {0, 1}, {0, -1}, {1, 0}
    };
    
    private void print(int[][] arr){
        for(int[] row : arr){
            for(int c : row) System.out.print(c + " ");
            
            System.out.println();
        }
        System.out.println();
    }
    
    private boolean xor(boolean a, boolean b){
        return (a || b) && !(a && b);
    }    
    
    private int[][] getSafetyMatrix(List<List<Integer>> grid){
        
        int n = grid.size();
        int[][] safety = new int[n][n];
        for(int[] row : safety) Arrays.fill(row, INF);
        
        Queue<int[]> cells = new LinkedList<>();
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(grid.get(i).get(j) == 1) {
                    cells.add(new int[]{i, j});
                    safety[i][j] = 0;
                }
            }
        }
        
        while(!cells.isEmpty()){
            int size = cells.size();
            while(size --> 0){
                int[] curr = cells.poll();
                
                int i = curr[0];
                int j = curr[1];
                
                for(int[] dir : dirs){
                    int x = i + dir[0];
                    int y = j + dir[1];
                    
                    if(x < 0 || x >= n || y < 0 || y >= n) continue;                    
                    if(safety[x][y] != INF) continue;

                    safety[x][y] = 1 + safety[i][j];
                    cells.add(new int[]{x, y});
                }                                
            }
        }
        
        return safety;
    }
    
    private boolean hasPath(int target, int[][] safety){
        
        int n = safety.length;
        
        if(safety[0][0] < target || safety[n - 1][n - 1] < target) 
            return false;
        
        Queue<int[]> nodes = new LinkedList<>();
        nodes.add(new int[]{0, 0});
        
        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;
        while(!nodes.isEmpty()){
            
            int size = nodes.size();
            while(size --> 0){
                
                int[] curr = nodes.poll();
                
                if(curr[0] == n - 1 && curr[1] == n - 1) return true;
                
                for(int[] dir : dirs){
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    
                    if(x < 0 || x >= n || y < 0 || y >= n) continue;                    
                    if(vis[x][y]) continue;
                    if(safety[x][y] < target) continue;
                    
                    vis[x][y] = true;
                    nodes.add(new int[]{x, y});
                }
            }
        }
        
        return false;
    }
    
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        
        int n = grid.size();
        int[][] safety = getSafetyMatrix(grid);
        
        int l = 0, r = 2 * (n - 1);
        while(l < r){
            int mid = (l + r + 1) / 2;
            if(hasPath(mid, safety)) l = mid;
            else r = mid - 1;
        }
        
        return r;
    }
}