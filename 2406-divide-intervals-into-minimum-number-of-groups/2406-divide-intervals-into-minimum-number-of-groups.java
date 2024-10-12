class Solution {
    public int minGroups(int[][] intervals) {
        if (intervals.length <= 1) return intervals.length;
        
        int[][] events = new int[intervals.length * 2][2];
        for(int i = 0; i < intervals.length; ++i){
            
            events[2 * i] = new int[]{intervals[i][0], 1};
            events[2 * i + 1] = new int[]{intervals[i][1] + 1, -1};            
        }
        
        Arrays.sort(events, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });
        
        int count = events[0][1];
        int maxCount = count;
        for(int i = 1; i < events.length; ++i){
            count += events[i][1];
            maxCount = Math.max(maxCount, count);
        }
        
        return maxCount;
    }
}