class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for(int candy : candies)
            maxCandies = Math.max(maxCandies, candy);
        
        List<Boolean> res = new ArrayList<Boolean>();
        for(int candy : candies)
            res.add((candy + extraCandies) >= maxCandies);
        
        return res;
    }
}