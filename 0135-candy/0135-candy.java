class Solution {
    
    public int solve(int i, int[] ratings, int[] candies){
        if(i < 0 || i > ratings.length) return 0;
        
        if(candies[i] != 0) return candies[i];
        
        // candies[i] = 1;
        
        int left = 0;
        if(i > 0 && ratings[i] > ratings[i - 1])
            left = solve(i - 1, ratings, candies);
        
        int right = 0;
        if(i < ratings.length - 1 && ratings[i] > ratings[i + 1])
            right = solve(i + 1, ratings, candies);
        
        return candies[i] = 1 + Math.max(left, right);
    }
    
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        for(int i = 0; i < ratings.length; ++i){
            if(candies[i] == 0)
                candies[i] = solve(i, ratings, candies);
        }
        
        int min = 0;
        for(int count : candies) min += count;
        return min;
    }
}