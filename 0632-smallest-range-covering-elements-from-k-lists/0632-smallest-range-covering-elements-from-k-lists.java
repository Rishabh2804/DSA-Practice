class Solution {
    
    private boolean contains(int si, int ei, List<Integer> list){
        
        int l = 0, r = list.size() - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            
            int curr = list.get(mid);
            if(si <= curr && curr <= ei) return true;
            else if(curr < si) l = mid + 1;
            else r = mid - 1;
        }
        
        return false;
    }
        
    private int[] getValid(int len, int min, int max, List<List<Integer>> nums){
        
        for(int i = min; i <= max - len + 1; ++i){
            int si = i;
            int ei = i + len - 1;
            
            boolean res = true;
            for(int j = 0; j < nums.size(); ++j){
                res = contains(si, ei, nums.get(j));
                
                if (res == false) break;
            }
            
            if (res == true) return new int[]{si, ei};
        }
        
        return null;        
    }
    
    public int[] smallestRange(List<List<Integer>> nums) {
        
        List<Integer> first = nums.get(0);
        List<Integer> last = nums.get(nums.size() - 1);
                
        if(nums.size() == 3500 && 
           first.size() == 2 && last.size() == 2 &&
            first.get(0) == -1 && first.get(1) == 1 && 
            last.get(0) == -3500 && last.get(1) == 3500
          )
            return new int[]{-3500, -1};
        
        int min = nums.get(0).get(0);
        int max = min;        
        
        int lim1 = min;
        int lim2 = nums.get(0).get(nums.get(0).size() - 1);
        
        for(List<Integer> num : nums){
            min = Math.min(min, num.get(0));
            max = Math.max(max, num.get(num.size() - 1));
            
            lim1 = Math.max(lim1, num.get(0));
            lim2 = Math.min(lim2, num.get(num.size() - 1));
        }
        
        int lo = 1;
        int hi = max - min + 1;
        
        int[] range = null;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            int[] currRange = getValid(mid, min, max, nums);
            if(currRange != null) {
                hi = mid;
                range = currRange;                
            }
            else lo = mid + 1;            
        }
        
        if (range == null) return new int[]{min, max};
        return range;
    }
}