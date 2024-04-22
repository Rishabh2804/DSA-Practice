class Solution {
    
    private int parse(String config){
        int code = 0;
        for(int i = 0; i < config.length(); ++i){
            code *= 10;
            code += config.charAt(i) - '0';
        }
        
        return code;
    }
    
    private int[] getNext(int curr){
        
        int[] codes = new int[8];
        int pos = 0;
        
        int num = 10;
        int subNum = 1;        
        for(int wheel = 0; wheel < 4; ++wheel){

            int slot = (curr % num) / subNum;
            
            int slotUp = slot + 1;
            int slotDown = slot - 1;
            
            if(slot == 0) slotDown = 9;
            else if(slot == 9) slotUp = 0;
            
            int codeUp = curr - (subNum * slot) + (subNum * slotUp);
            int codeDown = curr - (subNum * slot) + (subNum * slotDown);
            
            codes[pos++] = codeUp;
            codes[pos++] = codeDown;
            
            num *= 10;
            subNum *= 10;
        }
        
        return codes;
    }
    
    private int solveBFS(int start, int target, HashSet<Integer> deadends){
        
        if(deadends.contains(start)) return -1;
        
        Queue<Integer> configs = new LinkedList<>();
        configs.add(start);
        
        int step = 0;
        while(!configs.isEmpty()){
            int size = configs.size();
            while(size --> 0){
                int curr = configs.poll();
                if(curr == target) return step;
                
                int[] codes = getNext(curr);
                for(int code : codes){
                    if(deadends.contains(code)) continue;
                    
                    deadends.add(code);
                    configs.add(code);
                }
            }
            
            step++;
        }
        
        return -1;
    }
    
    private int solveDFS(int curr, int target, HashSet<Integer> deadends, HashMap<Integer, Integer> dp){
        
        if(deadends.contains(curr)) return -1;
        else if(curr == target) return 0;
        
        deadends.add(curr);
        
        if(dp.containsKey(curr)) return dp.get(curr);
        
        int minSteps = Integer.MAX_VALUE;
        
        int num = 10;
        int subNum = 1;        
        for(int wheel = 0; wheel < 4; ++wheel){

            int slot = (curr % num) / subNum;
            
            int slotUp = slot + 1;
            int slotDown = slot - 1;
            
            if(slot == 0) slotDown = 9;
            else if(slot == 9) slotUp = 0;
            
            int codeUp = curr - (subNum * slot) + (subNum * slotUp);
            int codeDown = curr - (subNum * slot) + (subNum * slotDown);
            
            int moveUp = solveDFS(codeUp, target, deadends, dp);
            int moveDown = solveDFS(codeDown, target, deadends, dp);
            
            if(moveUp != -1) minSteps = Math.min(minSteps, moveUp);
            if(moveDown != -1) minSteps = Math.min(minSteps, moveDown);
            
            num *= 10;
            subNum *= 10;
        }
        
        if(minSteps == Integer.MAX_VALUE) minSteps = -1;
        else minSteps ++;
        
        deadends.remove(curr);
        dp.put(curr, minSteps);        
        return minSteps;
    }
    
    public int openLock(String[] deadends, String target) {
        HashSet<Integer> deadEnds = new HashSet<>();
        for(String deadend : deadends) deadEnds.add(parse(deadend));
        
        HashMap<Integer, Integer> dp = new HashMap<>();
        int start = 0000;
        int end = parse(target);
        
        int minSteps = solveBFS(start, end, deadEnds);
        return minSteps;
    }
}