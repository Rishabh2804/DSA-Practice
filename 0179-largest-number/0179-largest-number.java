class Solution {
    
    
    public String largestNumber(int[] nums) {
        String[] num = new String[nums.length];
        
        for(int i = 0; i < nums.length; ++i){
            num[i] = "" + nums[i];
        }
        
        Arrays.sort(num, (a, b) -> (b + a).compareTo(a + b));
        
        if(num[0].equals("0"))
            return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String word : num)
            sb.append(word);
        
        return sb.toString();
    }
}