class Solution {
    public int countWays(List<Integer> nums) {
        int n = nums.size();   
        
        Collections.sort(nums);
        
        int[] max = new int[n];
        int[] min = new int[n + 1];
        
        max[0] = nums.get(0);
        for(int i = 1; i < n; ++i)
            max[i] = Math.max(max[i - 1], nums.get(i));
        
        min[n - 1] = nums.get(n - 1);
        for(int i = n - 2; i >= 0; --i)
            min[i] = Math.min(min[i + 1], nums.get(i));
        min[n] = Integer.MAX_VALUE;
        
        int ways = 0;
        if(min[0] > 0) ways++;
        
        for(int i = 0; i < n; ++i){
            int count = i + 1;
            if(count > max[i] && count < min[i + 1])
                ways++;
        }
        
        return ways;
    }
}