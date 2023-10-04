class Solution {
    public boolean canArrange(int[] arr, int k) {
        if(k == 1) return true;        
        
        int[] freq = new int[k];
        for(int i : arr){
            int i1 = i % k;
            if(i1 < k) {
                i1 += k;  
                i1 %= k;                
            }
            
            freq[i1]++;
        }
                
        for(int i = 1; i <= k / 2; ++i){
            if(freq[i] != freq[k - i]) 
                return false;
        }
        
        if(k % 2 == 0) return freq[k / 2] % 2 == 0;
        else return true;
    }
}