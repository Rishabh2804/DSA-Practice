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
    
    public boolean judgeSquareSum(int c) {
        
        for(int i : squares){
            if(i > c) break;
            
            boolean found = binarySearch(c - i, squares);
            if(found) return true;
        }
        
        return false;
    }
}