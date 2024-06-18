class Solution {
    private int upperBound(int[][] arr, int x){
        int si = 0, ei = arr.length - 1;
        while(si < ei){
            int mid = (si + ei + 1) / 2;
            if(arr[mid][0] > x) ei = mid - 1;
            else si = mid;
        }
        
        if(arr[ei][0] > x) return -1;
        return ei;
    }
    
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] workers) {
        int n = profit.length;
        int[][] jobs = new int[n][];
        
        for(int i = 0; i < n; ++i){
            jobs[i] = new int[]{difficulty[i], profit[i]};
        }
        
        Arrays.sort(jobs, (a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            else return a[0] - b[0];
        });
        
        int[] maxProfit = new int[n];
        maxProfit[0] = jobs[0][1];
        for(int i = 1; i < n; ++i){
            maxProfit[i] = Math.max(maxProfit[i - 1], jobs[i][1]);
        }
        
        int ans = 0;
        for(int worker : workers){
            int pos = upperBound(jobs, worker);
            if(pos != -1) ans += maxProfit[pos];
        }
            
        return ans;
    }
}