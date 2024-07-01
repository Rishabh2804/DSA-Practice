class Solution {
    private static boolean isOdd(int n){
        return n % 2 == 1;
    }
    
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i = 2; i < arr.length; ++i){
            if(isOdd(arr[i]) && isOdd(arr[i - 1]) && isOdd(arr[i - 2])) return true;
        }
        
        return false;
    }
}