class Solution {
    
    static final int SI = 0;
    static final int EI = 1;
    
    static final int MAX = 100000;
    static final int NULL = MAX;
        
    private int solveDP(int i, int garden_si, int garden_ei, int[][] taps, Integer[][] garden){
        
        // whole garden watered
        if(garden_si >= garden_ei) return 0;         
        // no taps left
        else if(i >= taps.length) return MAX;
        // some area left before this tap,  hence unwaterable
        else if(taps[i][SI] > garden_si) return MAX; 

        if(garden[garden_si][i] != null) return garden[garden_si][i];
        
        int leave = solveDP(i + 1, garden_si, garden_ei, taps, garden);
        int take = MAX;
        if(taps[i][EI] >= garden_si)
            take = 1 + solveDP(i + 1, Math.max(garden_si, taps[i][EI]), garden_ei, taps, garden);
        
        return garden[garden_si][i] = Math.min(leave, take);
    }
    
    // DP Solution 
    // TC -> O(n*n)
    // SC -> O(n*n) --> Memory Limit Exceeded
    private int solve1(int[][] taps){
        int n = taps.length;
        Integer[][] garden = new Integer[n][n];
        int minTaps = solveDP(0, 0, n - 1, taps, garden);
        
        if(minTaps >= MAX) return -1;
        else return minTaps;        
    }
    
    private int solve2(int[][] taps){
        
        int n = taps.length;
        
        int count = 0;
        
        int gardenEnd = n - 1;
        int covered = 0;
        
        int i = 0;    
        while(i < n){
            
            boolean canWater = false;
            int newRange = covered;
            while(i < n){
                if(taps[i][SI] > covered) break;
                
                canWater = true;
                newRange = Math.max(newRange, taps[i][EI]);
                i++;
            }
            
            if(!canWater) return -1; // couldn't even enter the tap selection loop
            
            if(newRange > covered){
                covered = newRange;
                count++;
            }
            
            if(newRange >= gardenEnd) return count;
        }
        
        if(covered < gardenEnd) return -1;
        return count;
    }
    
    private void print(int[][] ranges){
        for(int[] range : ranges){
            System.out.println(range[SI] + " " + range[EI]);
        }
    }
    
    public int minTaps(int n, int[] ranges) {
        int[][] taps = new int[n + 1][2];
        
        for(int i = 0; i < ranges.length; ++i)
            taps[i] = new int[]{i - ranges[i], i + ranges[i]};
        
        Arrays.sort(taps, (a, b) -> {
            if(a[SI] == b[SI]) return a[EI] - b[EI];
            else return a[SI] - b[SI];
        });
        
        print(taps);
        return solve2(taps);
    }
}