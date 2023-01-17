class Solution {
    public int minFlipsMonoIncr(String s) {
        List<Integer> zeroes = new ArrayList<>();
        List<Integer> ones = new ArrayList<>();
        
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '0')
                zeroes.add(i);
            else
                ones.add(i);
        }        
        
        // No flip is required for all 1s or all 0s
        if(ones.size() == 0 || zeroes.size() == 0)
            return 0;
                
        // if there exist only a single 0 or single 1, only 1 flip is required     
        if(zeroes.size() == 1){
            if(zeroes.get(0) == 0)
                return 0;
            else return 1;
        }
        else if(ones.size() == 1){
            if(ones.get(0) == s.length() - 1)
                return 0;
            else return 1;
        }

        int[] flip0 = new int[zeroes.size()];
        int[] flip1 = new int[ones.size()];
        
        // number of 1s before first 0 is 
        // equal to its position in String s
        flip0[0] = Math.min(1, zeroes.get(0)); 
        
        for(int i = 1; i < zeroes.size(); ++i){
            // one operation for flip + flip operations for last zero
            int surrender = 1 + flip0[i - 1];
            
            // No of 1s will be:- 
            // position in String s - no of 0s present till that position
            int flipAll = zeroes.get(i) - i; 
            
            flip0[i] = Math.min(surrender, flipAll);
        }
        
        // Same approach for 1, reversed
        int lastIdx = ones.size() - 1;
        flip1[lastIdx] = Math.min(1, s.length() - 1 - ones.get(lastIdx));
        
        for(int i = lastIdx - 1; i >= 0; --i){
            int surrender = 1 + flip1[i + 1];
                        
            int charAfterI = s.length() - 1 - ones.get(i);
            int onesAfterI = lastIdx - i;
            int flipAll = charAfterI - onesAfterI;
            
            flip1[i] = Math.min(surrender, flipAll);
        }
        
        return Math.min(flip0[flip0.length - 1], flip1[0]);
    }
}