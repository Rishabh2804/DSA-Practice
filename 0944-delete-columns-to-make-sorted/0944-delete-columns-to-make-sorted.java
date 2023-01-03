class Solution {
    public int minDeletionSize(String[] strs) {
        int dlt = 0;
        
        int n = strs[0].length();
        for(int i = 0; i < n; ++i){        
            for(int j = 1; j < strs.length; ++j){
                if(strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    dlt++;
                    break;
                }
            }                    
        }
         
        return dlt;
    }
}