class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
                
        int suffixSum = 0;
        int currSat = 0;
        int maxSat = 0;
        for(int i = n - 1; i >= 0; --i){           
            suffixSum += satisfaction[i];

            currSat += suffixSum;
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