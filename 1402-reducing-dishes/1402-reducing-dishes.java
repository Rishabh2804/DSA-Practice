class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
                
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = satisfaction[n - 1];
        for(int i = n - 2; i >= 0; --i)
            suffixSum[i] = satisfaction[i] + suffixSum[i + 1];
        
        int currSat = 0;
        int maxSat = 0;
        for(int i = n - 1; i >= 0; --i){
            currSat += suffixSum[i];
            maxSat = Math.max(maxSat, currSat);
        }
        
        return maxSat;
    }
}

// -9 -8 -1 0 5
//            5 = 5                         = 5
//          0 5 = 5*2 + 0                   = 10
//       -1 0 5 = 5*3 + 0*2 - 1             = 14 <--
//    -8 -1 0 5 = 5*4 + 0*3 - 1*2 - 8       = 10
// -9 -8 -1 0 5 = 5*5 + 0*4 - 1*3 - 8*2 - 9 = 6