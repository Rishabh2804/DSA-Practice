class Solution {
    public boolean winnerOfGame(String colors) {
        if(colors.length() < 3) return false;
        
        int alice = 0;
        int bob = 0;
        
        int count = 1;
        char start = colors.charAt(0);
        for(int i = 1; i < colors.length(); ++i){
            char curr = colors.charAt(i);
            if(curr == start)
                count++;
            else{
                if(count >= 3){
                    if(start == 'A') alice += count - 2;
                    else if(start == 'B') bob += count - 2;
                }
                
                start = curr;
                count = 1;
            }
        }

        if(count >= 3){
            if(start == 'A') alice += count - 2;
            else if(start == 'B') bob += count - 2;
        }
        
        return alice > bob;
    }
}