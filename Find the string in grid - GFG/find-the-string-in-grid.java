//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    private boolean search(int i, int j, int x, int y, char[][] grid, int si, String word){
        if(si >= word.length()) return true;
        
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return false;
        
        if(grid[i][j] != word.charAt(si)) return false;
        
        return search(i + x, j + y, x, y, grid, si + 1, word);
    }
    
    public int[][] searchWord(char[][] grid, String word)
    {
        List<int[]> coordinates = new ArrayList<>();
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                
                boolean found = false;
                for(int x = -1; x <= 1; ++x){
                    for(int y = -1; y <= 1; ++y){
                        if(x == 0 && y == 0) continue;
                        
                        found = search(i, j, x, y, grid, 0, word);
                        if(found){
                            coordinates.add(new int[]{i, j});
                            break;
                        }
                    }
                    
                    if(found) break;
                }
            }
        }
        
        int[][] res = new int[coordinates.size()][2];
        for(int i = 0; i < coordinates.size(); ++i)
            res[i] = coordinates.get(i);
            
        return res;
    }
}