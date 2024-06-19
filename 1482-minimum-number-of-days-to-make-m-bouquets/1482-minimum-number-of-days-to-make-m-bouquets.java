class Solution {
    
    private boolean validate(int day, int m, int k, int[] flowers){        
        int si = 0;
        for(int ei = 0; ei < flowers.length; ++ei){                            
            if(flowers[ei] > day){
                si = ei + 1;
                continue;
            }
            
            if(ei - si + 1 >= k){
                m--;
                si = ei + 1;
            }
            
            if(m <= 0) return true;
        }
        
        return false;
    }
    
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(1L * n < 1L * m * k) return -1;
        
        int max = 0;
        for(int i : bloomDay) max = Math.max(max, i);
            
        int l = 1, r = max;
        while(l < r){
            int mid = (l + r) / 2;
            if(validate(mid, m, k, bloomDay)) r = mid;
            else l = mid + 1;
        }
        
        return l;
    }
}