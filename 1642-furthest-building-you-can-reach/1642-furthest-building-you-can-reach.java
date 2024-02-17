class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        PriorityQueue<Integer> gaps = new PriorityQueue<>();
        
        int i = 0;
        for(i = 0; i < heights.length - 1; ++i){
            
            if(heights[i] >= heights[i + 1]) continue;
            
            int diff = heights[i + 1] - heights[i];
            
            gaps.add(diff);
            
            if(gaps.size() > ladders)
                bricks -= gaps.poll();
            
            if(bricks < 0) break;
        }
        
        return i;
    }
}