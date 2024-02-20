class Solution {

    static final int xorN(int n){
        return switch(n % 4){
            case 0 -> n;
            case 1 -> 1;
            case 2 -> n + 1;
            default -> 0;
        };
    }
    
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xorAll = xorN(n);
        
        for(int i : nums)
            xorAll ^= i;
        
        return xorAll;
    }
}