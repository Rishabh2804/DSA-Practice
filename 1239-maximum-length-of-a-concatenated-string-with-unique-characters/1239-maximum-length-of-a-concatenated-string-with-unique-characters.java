class Solution {
    
    private int solve(int i, List<Integer> masks, int currMask){
        if(i >= masks.size()) return Integer.bitCount(currMask);
        
        int leave = solve(i + 1, masks, currMask);
        
        int take = 0;        
        if((masks.get(i) & currMask) == 0){
            currMask |= masks.get(i);
            
            take = solve(i + 1, masks, currMask);
        } 
        
        return Math.max(leave, take);
    }
    
    private int getMask(String str){
        
        int mask = 0;
        for(int i = 0; i < str.length(); ++i){
            int currBit = 1 << (str.charAt(i) - 'a');
            
            if((mask & currBit) == 0) mask |= currBit;
            else return 0;            
        }
        
        return mask;
    }
    
    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<>();
        for(String str : arr)
            masks.add(getMask(str));
        
        return solve(0, masks, 0);
    }
}