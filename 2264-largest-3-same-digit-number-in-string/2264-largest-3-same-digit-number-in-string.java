class Solution {
    
    private static final int NONE = -1;
    private static final String[] res = {"000", "111", "222",
                                         "333", "444", "555",
                                         "666", "777", "888", "999"};
    
    public String largestGoodInteger(String num) {
        
        int max = NONE;
        
        int count = 1;
        for (int i = 1; i < num.length(); ++i){
            if(num.charAt(i) == num.charAt(i - 1)) count++;
            else count = 1;
            
            if(count >= 3) max = Math.max(max, num.charAt(i) - '0');
        }
        
        if(max == NONE) return "";
        else return res[max];
    }
}