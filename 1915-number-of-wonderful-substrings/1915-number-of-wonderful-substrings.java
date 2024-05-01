class Solution {
    
    private List<Integer> getDiffMasks(int currMask) {
        
        List<Integer> masks = new ArrayList<>();
        for(int i = 0; i < 26; ++i){
            int bit = 1 << i;
            int mask = currMask ^ bit;
            masks.add(mask);
        }
        
        return masks;
    }
    
    public long wonderfulSubstrings(String word) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        long count = 0;
        
        int currMask = 0;
        for(int i = 0; i < word.length(); ++i){
            int curr = word.charAt(i) - 'a';
            currMask ^= 1 << curr;
            
            List<Integer> masks = getDiffMasks(currMask);
            for(int mask : masks){
                int currCount = map.getOrDefault(mask, 0);
                count += currCount;
            }
            
            int currCount = map.getOrDefault(currMask, 0);
            count += currCount;
            
            map.put(currMask, currCount + 1);
        }
        
        return count;
    }
}