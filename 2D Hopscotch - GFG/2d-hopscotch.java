//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int mat[][] = new int[n][m];
            for(int i = 0;i < n;i++){
                String a[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < m;j++)
                    mat[i][j] = Integer.parseInt(a[j]);
            }
            String a1[] = in.readLine().trim().split("\\s+");
            int ty = Integer.parseInt(a1[0]);
            int i = Integer.parseInt(a1[1]);
            int j = Integer.parseInt(a1[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.hopscotch(n, m, mat, ty, i, j));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int hopscotch(int n, int m, int mat[][], int ty, int i, int j) 
    {
        int stones = 0;
        
        int s = j % 2;
        
        if(ty == 0) { // Director : Avantika (1 step)
            
            // North
            stones += get(i - 1, j, mat);
                
            // West
            stones += get(i - 1 + s, j - 1, mat);
            stones += get(i + s, j - 1, mat);
            
            // East
            stones += get(i - 1 + s, j + 1, mat);
            stones += get(i + s, j + 1, mat);
            
            // South
            stones += get(i + 1, j, mat);
        }
        else{
            // North
            stones += get(i - 2, j, mat);
                
            // West
            stones += get(i - 2 + s, j - 1, mat);
            
            stones += get(i - 1, j - 2, mat);
            stones += get(i, j - 2, mat);
            stones += get(i + 1, j - 2, mat);
            
            stones += get(i + 1 + s, j - 1, mat);
            
            // East
            stones += get(i - 2 + s, j + 1, mat);
            
            stones += get(i - 1, j + 2, mat);
            stones += get(i, j + 2, mat);
            stones += get(i + 1, j + 2, mat);
            
            stones += get(i + 1 + s, j + 1, mat);
            
            // South
            stones += get(i + 2, j, mat);
        }
        
        return stones;
    }
    
    static int get(int i, int j, int[][] mat){
        if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length)
            return 0;
        
        return mat[i][j];
    }
}