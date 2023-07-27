class Solution {
    public long maxRunTime(int n, int[] batteries) {        
        int m = batteries.length;
        Arrays.sort(batteries);
        
        long extraPower = 0;
        for(int i = 0; i < m - n; ++i)
            extraPower += batteries[i];
        
        int start = m - n;        
        for(int i = start; i < m - 1; ++i){
            int diff = batteries[i + 1] - batteries[i];
            long reqPower = (i - start + 1) * diff;
            
            if(reqPower <= extraPower) extraPower -= reqPower;
            else return (long) (batteries[i] + extraPower / (i - start + 1));            
        }
        
        return batteries[m - 1] + extraPower / n;
    }
}