class Solution {
    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<>();
        for(String str : arr)
            masks.add(stringToMask(str));
        
        return solve(0, 0, masks);
    }
    
    public int stringToMask(String str){
        
        int mask = 0;
        for(int i = 0; i < str.length(); ++i){
            int currBit = 1 << (str.charAt(i) - 'a');
            if((currBit & mask) == 0)
                mask |= currBit;
            else
                return 0;
            
        }
                
        return mask;
    }
    
    public int solve(int i, int currMask, List<Integer> masks){
        if(i >= masks.size())
            return length(currMask);
                
        int ans1 = solve(i + 1, currMask, masks);
        int ans2 = 0;
        if((currMask & masks.get(i)) == 0)
            ans2 = solve(i + 1, (currMask | masks.get(i)), masks);
        
        // System.out.println(masks.get(i) + " " + bits(currMask));
        // System.out.println(masks.get(i) + " " + bits(currMask | masks.get(i)));
        // System.out.println();
                
        return Math.max(ans1, ans2);
    }
    
    public int length(int mask){
        int count = 0;
        while(mask != 0){
            count += (mask & 1);
            mask >>= 1;
        }
        
        return count;
    }
    
    public List<Integer> bits(int n){
        List<Integer> bit = new ArrayList<>();
        while(bit.size() < 26){
            bit.add(n & 1);
            n >>= 1;
        }
        
        Collections.reverse(bit);
        return bit;
    }
}