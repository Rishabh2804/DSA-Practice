class Solution {
    public String predictPartyVictory(String senate) {
        int votes = 0;
        
        Queue<Character> senators = new LinkedList<>();
        for(int i = 0; i < senate.length(); ++i) {
            senators.add(senate.charAt(i));            
        }
        
        while(-1* senate.length() <= votes && votes <= senate.length()){
            char curr = senators.poll();
            if(curr == 'R'){
                if(votes >= 0)
                    senators.add(curr);
                
                votes++;                    
            } else{
                if(votes <= 0)
                    senators.add(curr);
                
                votes--;                    
            }
        }
        
        return (senators.peek() == 'R') ? "Radiant" : "Dire";
    }
}