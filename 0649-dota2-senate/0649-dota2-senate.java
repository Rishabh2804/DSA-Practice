class Solution {
    public String predictPartyVictory(String senate) {
        int votes = 0;
        
        int r = 0, d = 0;
        Queue<Character> senators = new LinkedList<>();
        for(int i = 0; i < senate.length(); ++i) {
            senators.add(senate.charAt(i));
            if(senate.charAt(i) == 'R') r++;
            else d++;
        }
        
        while(r > 0 && d > 0){
            char curr = senators.poll();
            if(curr == 'R'){
                if(votes >= 0)
                    senators.add(curr);
                else
                    r--;
                
                votes++;                    
            } else{
                if(votes <= 0)
                    senators.add(curr);
                else
                    d--;
                
                votes--;                    
            }
        }
        
        return (senators.peek() == 'R') ? "Radiant" : "Dire";
    }
}