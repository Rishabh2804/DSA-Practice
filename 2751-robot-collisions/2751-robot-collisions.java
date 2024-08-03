class Solution {
    
    private static final class Robot {
        int idx;
        int pos;
        int health;
        char dir;
        
        Robot(int idx, int pos, int health, char dir){
            this.idx = idx;
            this.pos = pos;
            this.health = health;
            this.dir = dir;
        }        
    }
    
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Robot[] robos = new Robot[positions.length];
        for(int i = 0; i < robos.length; ++i){
            robos[i] = new Robot(i, positions[i], healths[i], directions.charAt(i));
        }
        
        Arrays.sort(robos, (a, b) -> {
            return a.pos - b.pos;
        });
        
        
        Stack<Integer> space = new Stack<>();
        List<Robot> temp = new ArrayList<>();
        
        for(int i = 0; i < robos.length; ++i){
            Robot curr = robos[i];
            if(curr.dir == 'R') {
                space.add(i);
                continue;
            }
            
            int survivor = i;
            
            while(!space.isEmpty()){
                int topPos = space.pop();
                Robot top = robos[topPos];                
                if(top.health > curr.health) {
                    top.health--;
                    survivor = topPos;
                    break;
                } else if(top.health < curr.health){
                    curr.health --; 
                } else {
                    survivor = -1;
                    break;
                }
            }
            
            if(survivor == i) temp.add(curr);            
            else if(survivor != -1) space.add(survivor);
        }
        
        while(!space.isEmpty()){
            Robot curr = robos[space.pop()];
            temp.add(curr);
        }
        
        Collections.sort(temp, (a, b) -> a.idx - b.idx);
        
        List<Integer> surv = new ArrayList<>();
        for(Robot robo : temp) surv.add(robo.health);
        
        return surv;
    }
}