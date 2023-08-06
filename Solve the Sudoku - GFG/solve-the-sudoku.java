//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    static final int BOARD_SIZE = 9;
    static final int ROW_CHECK = 1; // 001
    static final int COL_CHECK = 2; // 010
    static final int BOX_CHECK = 4; // 100
    
    static int[][] gridMap;
    
    static int count = 0;
    
    static boolean solve(int row, int col, int[][] grid){
        count++;
        row += col / BOARD_SIZE; // if col idx overflows, row idx would be shifted
        col %= BOARD_SIZE;     // col idx adjusted accordingly
        
        // if whole board has been traversed
        if(row >= BOARD_SIZE) 
            return true;
        
        if(grid[row][col] != 0) return solve(row, col + 1, grid);
        
        int box = 3 * (row / 3) + (col / 3);
        
        for(int num = 0; num < 9; ++num){
            int check_row = gridMap[row][num] & ROW_CHECK;
            int check_col = gridMap[col][num] & COL_CHECK;
            int check_box = gridMap[box][num] & BOX_CHECK;
            
            if(check_row != 0 || check_col != 0 || check_box != 0)
                continue;
            
            // set corresponding value in grid
            grid[row][col] = num + 1;
            gridMap[row][num] ^= ROW_CHECK;
            gridMap[col][num] ^= COL_CHECK;
            gridMap[box][num] ^= BOX_CHECK;
                
            boolean ans = solve(row, col + 1, grid);
            if(ans) return true;
            
            // clear num from grid
            grid[row][col] = 0;
            gridMap[row][num] ^= ROW_CHECK;
            gridMap[col][num] ^= COL_CHECK;
            gridMap[box][num] ^= BOX_CHECK;
        }
        
        return false;
    }
    
    static void initMap(int[][] grid){
        count = 0;
        gridMap = new int[BOARD_SIZE][BOARD_SIZE];
        int box = -1;
        for(int row = 0; row < BOARD_SIZE; ++row){
            for(int col = 0; col < BOARD_SIZE; ++col){
                if(grid[row][col] == 0) continue;
    
                box = 3 * (row / 3) + (col / 3);
            
                int num = grid[row][col] - 1;
                gridMap[row][num] ^= ROW_CHECK;
                gridMap[col][num] ^= COL_CHECK;
                gridMap[box][num] ^= BOX_CHECK;
            }
        }
    }
    
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        initMap(grid);   
        return solve(0, 0, grid);
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // System.out.println(count);
        
        for(int[] row : grid){
            for(int cell : row)
                System.out.print(cell + " ");
                
            //  System.out.println();
        }
    }
}