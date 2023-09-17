class Solution {
    
    private int getBits(int n){
        int count = 0;
        while(n > 0){
            count += n & 1;
            n >>= 1;            
        }
        
        return count;
    }
    
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        
        int sum = 0;
        for(int i = 0; i < nums.size(); ++i){
            if(getBits(i) == k)
                sum += nums.get(i);
        }
        
        return sum;
    }
}