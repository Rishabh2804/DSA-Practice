class Solution {    
    static final char[][] KEYS = {
        {},
        {}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
        {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}                      
    };
    
    private List<String> solve(int i, String digits){
        List<String> combinations = new ArrayList<>();
        if(i >= digits.length()) {
            combinations.add("");
            return combinations;
        }
        
        List<String> postAns = solve(i + 1, digits);
        int currDigit = digits.charAt(i) - '0';
        char[] currLetters = KEYS[currDigit];
        
        for(char c : currLetters){
            for (String comb : postAns)
                combinations.add(c + comb);
        }
        
        return combinations;
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        
        return solve(0, digits);    
    }
}