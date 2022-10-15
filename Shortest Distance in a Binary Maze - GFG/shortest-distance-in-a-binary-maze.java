//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        ArrayList<int[]> arrlist = new ArrayList<>(grid.length * grid[0].length);
        int steps = 0 ;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int l = 0 ; l < grid.length ; l++){
            for(int m = 0 ; m < grid[0].length ; m++){
                if(grid[l][m] == 0){
                    visited[l][m] = true;
                }
            }
        }
        arrlist.add(source);
        while (arrlist.size() > 0) {
int size = arrlist.size();
            for(int j = 0 ; j < size ; j++) {
                int[] cur = arrlist.get(0);
                int currow = cur[0];
                int curcolumn = cur[1];
                arrlist.remove(0);
                if(currow== destination[0] && curcolumn == destination[1]){
                    return steps;
                }

                if (currow - 1 >= 0 && !visited[currow - 1][curcolumn]) {
                    arrlist.add(new int[]{currow - 1, curcolumn});
                    visited[currow-1][curcolumn] = true;
                }
                if (currow + 1 < grid.length && !visited[currow + 1][curcolumn]) {
                    arrlist.add(new int[]{currow + 1, curcolumn});
                    visited[currow+1][curcolumn] = true;

                }

                if (curcolumn - 1 >= 0 && !visited[currow][curcolumn - 1]) {
                    arrlist.add(new int[]{currow, curcolumn - 1});
                    visited[currow][curcolumn -1] = true;

                }

                if (curcolumn + 1 < grid[0].length && !visited[currow][curcolumn + 1]) {
                    arrlist.add(new int[]{currow, curcolumn + 1});
                    visited[currow][curcolumn+ 1] = true;

                }

            }
            steps++;
        }
        return -1;

    }
}