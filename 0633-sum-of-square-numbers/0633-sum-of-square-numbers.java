class Solution {
    
    private static final int[] squares;
    private static final int SIZE = 1 << 16;
    
    static {        
        squares = new int[SIZE];
        for(int i = 0; i < SIZE; ++i)
            squares[i] = i * i;
    }
    
    private boolean binarySearch(int x, int[] arr){
        int si = 0, ei = arr.length - 1;
        while(si <= ei){
            int mid = (si + ei) / 2;
            if(arr[mid] == x) return true;
            else if(arr[mid] < x) si = mid + 1;
            else ei = mid - 1;
        }
        
        return false;
    }
    
    private boolean solveBS(int c){
        for(int i : squares){
            if(i > c) break;
            
            boolean found = binarySearch(c - i, squares);
            if(found) return true;
        }
        
        return false;   
    }
    
    private boolean solveTwoPointer(int c, int[] arr){
        if(c == 0) return true;
        
        int si = 0, ei = arr.length - 1;
        while(si < ei){            
            
            if(arr[si] > c) return false;
            if(si < ei && arr[ei] == c - arr[si]) return true;            
            
            while(si < ei && arr[ei] > c - arr[si]) ei--;
            while(si < ei && arr[ei] < c - arr[si]) si++;           
            
            System.out.println(si + " " + ei);
        }
        
        return false;
    }
    
    public boolean judgeSquareSum(int c) {
        return solveBS(c);
    }
}