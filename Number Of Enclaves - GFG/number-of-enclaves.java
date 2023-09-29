//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    static final int WATER = 0;
    static final int LAND = 1;
    
    int[] xDir = {-1,  0, 1, 0};
    int[] yDir = { 0, -1, 0, 1};
    
    void removeShores(int i, int j, int[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
            
        if(grid[i][j] == WATER) return;
        
        grid[i][j] = WATER;
        
        for(int dir = 0; dir < 4; ++dir){
            int x = i + xDir[dir];
            int y = j + yDir[dir];
            
            removeShores(x, y, grid);
        }
    }
    
    int numberOfEnclaves(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i = 0; i < n; ++i){
            removeShores(i, 0, grid);
            removeShores(i, m - 1, grid);
        }
        
        for(int j = 0; j < m; ++j){
            removeShores(0, j, grid);
            removeShores(n - 1, j, grid);
        }
        
        int count = 0;
        for(int[] row : grid){
            for(int cell : row)
                count += cell;
        }
        
        return count;
    }
}