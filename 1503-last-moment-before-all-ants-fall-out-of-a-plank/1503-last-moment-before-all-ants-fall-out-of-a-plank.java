class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int lastMoment = 0;
        
        for(int antPos : left)
            lastMoment = Math.max(lastMoment, antPos - 0);
        
        for(int antPos : right)
            lastMoment = Math.max(lastMoment, n - antPos);
        
        return lastMoment;
    }
}