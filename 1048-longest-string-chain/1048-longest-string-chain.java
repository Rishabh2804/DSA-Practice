class Solution {
    static final int MAX_LEN = 16;
    
    private boolean isSubsequence(String s1, String s2){
        int i = 0;
        int j = 0;
        
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j))
                i++;
            
            j++;
        }
        
        return i == s1.length();
    }
    
    private int solve(String curr, HashMap<Integer, List<String>> wordReg, HashMap<String, Integer> dp){
        
        if(dp.containsKey(curr))
            return dp.get(curr);
        
        int nextLen = curr.length() + 1;        
        if(!wordReg.containsKey(nextLen)) return 0;
        
        int ans = 0;
        List<String> nextWords = wordReg.get(nextLen);
        for(String next : nextWords){
            if(isSubsequence(curr, next))
                ans = Math.max(ans, 1 + solve(next, wordReg, dp));
        }
        
        dp.put(curr, ans);
        return ans;
    }
    
    public int longestStrChain(String[] words) {
        HashMap<Integer, List<String>> wordReg = new HashMap<>();
        for(String word : words){
            int len = word.length();
            
            List<String> wordList = wordReg.getOrDefault(len, new ArrayList<>());
            wordList.add(word);
            
            wordReg.put(len, wordList);
        }
        
        HashMap<String, Integer> dp = new HashMap<>();
        
        int ans = 1;
        for(int len = 1; len <= MAX_LEN; ++len){
            if(!wordReg.containsKey(len)) continue;
            List<String> wordList = wordReg.get(len);
            
            for(String word : wordList)
                ans = Math.max(ans, 1 + solve(word, wordReg, dp));
        }
        
        return ans;
    }
}