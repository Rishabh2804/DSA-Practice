class Solution {
    
    private int[] getFreq(String hash){
        String[] tokens = hash.split(" ");
        
        int[] freq = new int[26];
        for(int i = 0; i < tokens.length; ++i)
            freq[i] = Integer.parseInt(tokens[i]);
        
        return freq;
    }
    
    private String compress(int[] freq){
        StringBuilder sb = new StringBuilder();
        for(int i : freq) {
            sb.append("" + i);
            sb.append(' ');
        }
        
        return sb.toString();
    }
    
    private int check(String word, int[] freq, int[] score){
        
        int[] req = new int[26];
        for(int i = 0; i < word.length(); ++i){
            req[word.charAt(i) - 'a']++;
        }
        
        int sc = -1;
        for(int i = 0; i < 26; ++i){
            if(req[i] > freq[i]) return -1;
            else {
                if(sc == -1) sc = 0;
                
                sc += score[i] * req[i];
                freq[i] -= req[i];
            }
        }
        
        return sc;
    }
    
    private int solve(int i, String[] words, int[] score, String currFreq, HashMap<Integer, HashMap<String, Integer>> dp){
        if(i >= words.length) return 0;
        
        if(dp.get(i) != null && dp.get(i).containsKey(currFreq)) return dp.get(i).get(currFreq);
        
        int leave = solve(i + 1, words, score, currFreq, dp);
        
        int take = 0;
        int[] freq = getFreq(currFreq);
        
        int currScore = check(words[i], freq, score);
        if(currScore != -1){
            
            String newFreq = compress(freq);
            
            take = currScore + solve(i + 1, words, score, newFreq, dp);
        }
        
        int max = Math.max(leave, take);
        dp.get(i).put(currFreq, max);
        return max;
    }
    
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];
        for(char c : letters) freq[c - 'a']++;
        
        String currFreq = compress(freq);
        
        HashMap<Integer, HashMap<String, Integer>> dp = new HashMap<>();
        for(int i = 0; i < words.length; ++i) dp.put(i, new HashMap<>());
        
        int ans = solve(0, words, score, currFreq, dp);
        
        return ans;
    }
}