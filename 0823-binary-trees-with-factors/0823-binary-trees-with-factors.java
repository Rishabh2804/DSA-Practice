class Solution {
    static final int MOD = 1000000007;
    
    private static final int ADD(int a, int b){
        return (a + b) % MOD;
    }
    
    private static final int MULT(int a, int b){
        return (int)((1l * a * b) % MOD);
    }
    
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer, Integer> factorWays = new HashMap<>();
        
        for(int num : arr){
            
            int currWays = 1;
            for(int fac = 2; fac * fac <= num; ++fac){                
                if(num % fac == 0){
                    if(fac * fac == num && factorWays.containsKey(fac))
                        currWays = ADD(currWays, 
                                       MULT(
                                           factorWays.get(fac),
                                           factorWays.get(fac)
                                       ));
                    else 
                        if(factorWays.containsKey(fac) && factorWays.containsKey(num /fac))
                        currWays = ADD(currWays, 
                                       MULT(
                                           2 * factorWays.get(fac),
                                           factorWays.get(num / fac)
                                       ));
                }
            }
            
            factorWays.put(num, currWays % MOD);
        }
        
        int totalWays = 0;
        for(int ways : factorWays.values())
            totalWays = ADD(totalWays, ways);
        
        return totalWays % MOD;
    }
}