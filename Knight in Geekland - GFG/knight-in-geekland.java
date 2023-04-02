//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            s = br.readLine().trim().split(" ");

            int start_x = Integer.parseInt(s[0]);
            int start_y = Integer.parseInt(s[1]);
            int arr[][] = new int[n][m];
            for(int i = 0; i < n; i++){
                s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    arr[i][j] = Integer.parseInt(s[j]);
            }

            Solution soln = new Solution();
            ot.println(soln.knightInGeekland(arr, start_x, start_y));
            
        }

        ot.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static final int[] xDir = { 2,  1, -1, -2, -2, -1,  1, 2};
    static final int[] yDir = {-1, -2, -2, -1,  1,  2,  2, 1};
    
    public int knightInGeekland(int arr[][], int start_x, int start_y){
        
        int n = arr.length;
        int m = arr[0].length;
        
        int[] coinsTable = new int[500];
        coinsTable[0] = arr[start_x][start_y];
        arr[start_x][start_y] = -1;
        
        Queue<int[]> steps = new LinkedList<>();
        steps.add(new int[]{start_x, start_y});
        
        int moves = 0;
        while(!steps.isEmpty()){
            int size = steps.size();
            
            int nextCoins = 0;
            while(size --> 0) {
                int[] currStep = steps.poll();
                
                for(int dr = 0; dr < 8; ++dr){
                    int x = currStep[0] + xDir[dr];
                    int y = currStep[1] + yDir[dr];
                    
                    if(0 <= x && x < n && 0 <= y && y < m && arr[x][y] != -1){
                        nextCoins += arr[x][y];
                        // System.out.println(x + " " + y + " " + arr[x][y]);
                        
                        arr[x][y] = -1;
                        
                        steps.add(new int[]{x, y});
                    }
                }
            }
            
            // System.out.println();
            moves++;
            coinsTable[moves] = nextCoins;
        }
        
        return countMoves(coinsTable, moves);
    }
    
    public int countMoves(int[] arr, int n){
        
        int maxCoins = arr[n];
        int moves = n;
        
        for(int i = n; i >= 0; --i){
            if(i + arr[i] <= n)
                arr[i] += arr[i + arr[i]];
                
            if(arr[i] >= maxCoins){
                maxCoins = arr[i];
                moves = i;
            }
            
        }
        
        return moves;
    }
}   
