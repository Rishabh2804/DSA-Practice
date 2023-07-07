class Solution {
    
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int[] prefix1 = new int[n + 1];
        int[] prefix2 = new int[n + 1];
        
        for(int i = 1; i <= n; ++i){
            if(answerKey.charAt(i - 1) == 'T'){
                prefix1[i] = 1 + prefix1[i - 1];  
                prefix2[i] = prefix2[i - 1];  
            }
            else{
                prefix1[i] = prefix1[i - 1];  
                prefix2[i] = 1 + prefix2[i - 1];  
            }
        }
        
        for(int i : prefix1) System.out.print(i + " ");
        System.out.println();
        for(int i : prefix2) System.out.print(i + " ");
        System.out.println();

        int si = 0, ei = n + 1;
        int mid = (si + ei + 1) / 2;
        while(si < ei){
            mid = (si + ei + 1) / 2;
            boolean found = false;
            for(int i = mid; i <= n; ++i){
                int rangeSum1 = prefix1[i] - prefix1[i - mid];
                int rangeSum2 = prefix2[i] - prefix2[i - mid];
                
                if(rangeSum1 + k >= mid || rangeSum2 + k >= mid){
                    found = true;
                    break;
                }                                                    
            }
            
            if(found) si = mid;
            else ei = mid - 1;
        }
        
        return si;
    }
}