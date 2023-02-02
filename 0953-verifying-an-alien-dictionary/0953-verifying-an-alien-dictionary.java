class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        int[] dict = new int[26];
        int id = 0;
        for(int i = 0; i < order.length(); ++i)
            dict[order.charAt(i) - 'a'] = id++;
                    
        for(int i = 1; i < words.length; ++i){
            String pre = words[i - 1];
            String curr = words[i];
            
            boolean isSorted = false;
            int lim = Math.min(pre.length(), curr.length());
            for(int j = 0; j < lim; ++j){
                int idx1 = pre.charAt(j) - 'a';
                int idx2 = curr.charAt(j) - 'a';
                
                if(dict[idx1] > dict[idx2])
                    return false;
                else if(dict[idx1] < dict[idx2]){
                    isSorted = true;
                    break;                
                }
            }
            
            if(isSorted)
                continue;
            
            if(pre.length() > curr.length())
                return false;
        }
            
        return true;
    }
}