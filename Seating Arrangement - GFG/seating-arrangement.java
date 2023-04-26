//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int test = Integer.parseInt(in.readLine().trim());
        while(test-- > 0){
            int n = Integer.parseInt(in.readLine().trim());
            int m = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int [] seats = new int[m];
            for(int i = 0; i < m; i++){
                seats[i] = Integer.parseInt(s[i]);
            }
            Solution obj = new Solution();
            boolean res = obj.is_possible_to_get_seats(n, m, seats);
            
            String _result_val = (res) ? "Yes" : "No";
            out.println(_result_val);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static void occupySeats(int m, int[] seats){
        if(seats[0] == 1) 
            seats[1] = 2 - seats[1];
        
        for(int i = 1; i < m - 1; ++i){
            if(seats[i] == 1) {
                seats[i - 1] = 2 - seats[i - 1]; // 0 -> 2 ; 1 -> 1
                seats[i + 1] = 2 - seats[i + 1];
            }
        }
        
        if(seats[m - 1] == 1) 
            seats[m - 2] = 2 - seats[m - 2];
            
    }
    
    public static boolean is_possible_to_get_seats(int n, int m, int[] seats) {
        if(n == 0) return true;
        
        if(m == 1)
            return seats[0] == 0;
        
        occupySeats(m, seats);
        
        for(int i = 0; i < m - 1; ++i){
            if(seats[i] == 2) continue;
            
            if(seats[i] == 0)
                n--;
            
            if(n <= 0) return true;
            
            if(seats[i + 1] != 1)
                seats[i + 1] = 2;
        }
        
        if(seats[m - 1] == 0)
            n--;
            
        return n <= 0;
    }
}
        
