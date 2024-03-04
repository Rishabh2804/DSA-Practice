class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        
        Arrays.sort(tokens);
        
        int score = 0;
        int l = 0, r = tokens.length - 1;
        
        while(l <= r){
            if(l == r){
                if(power >= tokens[l])
                    score++;
                break;
            }
            
            if(power >= tokens[l]){
                score++;
                power -= tokens[l];
                l++;
            }
            else if(score > 0){
                score--;
                power += tokens[r];
                r--;
            }
            else
                break;
        }
        
        return score;
    }
}