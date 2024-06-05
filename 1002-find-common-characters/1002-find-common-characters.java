class Solution {
    
    public List<String> commonChars(String[] words) {
        int[] freq = null;
        
        for(String word : words){
            
            int[] currFreq = new int[26];
            for(int i = 0; i < word.length(); ++i){
                currFreq[word.charAt(i) - 'a']++;
            }
            
            if(freq == null) freq = currFreq;
            
            for(int i = 0; i < 26; ++i) 
                freq[i] = Math.min(freq[i], currFreq[i]);
        }
        
        List<String> list = new ArrayList<>();
        if(freq == null) return list;        
        
        for(int i = 0; i < 26; ++i){
            String curr = "" + (char)('a' + i);
            while(freq[i] --> 0) list.add(curr);
        }
        
        return list;        
    }
}