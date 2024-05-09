class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        
        int n = happiness.length;
        long total = 0;
        int dec = 0;
        for(int i = n - 1; i >= n - k; --i){
            happiness[i] -= dec;
            if(happiness[i] < 0) happiness[i] = 0;
            
            dec++;
            total += happiness[i];
        }
        
        // total -= 1L * (k - 1) * (k) / 2;
        
        return total;
    }
}