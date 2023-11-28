class Solution {
    private static final int MOD = 1000000007;
    
    private static final char SEAT = 'S';
    private static final char PLANT = 'P';
    
    private int getProduct(List<Integer> list){        
        int product = 1;
        
        for(int i = 0; i < list.size(); ++i)
            product = (int)((1L * product * (list.get(i) + 1)) % MOD);
        
        return product;
    }

    public int numberOfWays(String corridor) {
        
        List<Integer> plants = new ArrayList<>();
        int plantCount = Integer.MIN_VALUE;
        Boolean hasSeat = null;
        
        for(int i = 0; i < corridor.length(); ++i){
            char curr = corridor.charAt(i);
            if(curr == PLANT) plantCount++;
            else {
                if((hasSeat == null || !hasSeat) && plantCount >= 0)
                    plants.add(plantCount);
                
                plantCount = 0;
                if(hasSeat == null) hasSeat = true;
                else hasSeat = hasSeat == false;
            }
        }
        
        if(hasSeat == null || hasSeat) return 0; // no seat, or odd number of seats
        return getProduct(plants);
    }
}