class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] freq = new int[2001];
        for(int i : arr)
            freq[1000 + i]++;
                
        boolean[] freqMap = new boolean[1001];
        for(int f : freq){
            if(f == 0)
                continue;            
            else if(freqMap[f])
                return false;
            else
                freqMap[f] = true;
        }
        
        return true;
    }
}