class Solution {
    public long minimumPossibleSum(int n, int k) {
        long sum = 0;
        int i = 1;
        while (n > 0 && i <= k / 2){
            sum += i;
            i++;
            n--;
        }
        
        i = k;
        while(n > 0){
            sum += i;
            i++;
            n--;
        }
        
        return sum;
    }
}