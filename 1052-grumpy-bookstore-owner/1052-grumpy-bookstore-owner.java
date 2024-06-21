class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int[] count = customers;
        
        int[] satCount = new int[n];
        for(int i = 0; i < n; ++i){
            if(grumpy[i] == 1) satCount[i] = 0;
            else satCount[i] = count[i];
        }
        
        int[] pref = new int[n];
        int[] suff = new int[n];
        
        pref[0] = satCount[0];
        for(int i = 1; i < n; ++i) pref[i] = pref[i - 1] + satCount[i];
        
        suff[n - 1] = satCount[n - 1];
        for(int i = n - 2; i >= 0; --i) suff[i] = suff[i + 1] + satCount[i];
        
        int currCount = 0;
        for(int i = 0; i < minutes; ++i) currCount += count[i];
        
        if(n == minutes) return currCount;
        
        int max = currCount + suff[minutes];
        
        for(int i = 0; i < n - 1 - minutes; ++i){
            currCount += count[i + minutes] - count[i];
            int curr = pref[i] + suff[i + 1 + minutes] + currCount;
            max = Math.max(max, curr);
        }
        
        currCount += count[n - 1] - count[n - 1 - minutes];
        int last = pref[n - minutes - 1] + currCount;
        max = Math.max(max, last);
        
        return max;
    }
}