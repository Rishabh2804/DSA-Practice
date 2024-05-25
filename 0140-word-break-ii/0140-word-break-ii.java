class Solution {
    
    static class Trie{
        
        static class TrieNode {
            
            TrieNode[] children;
            int wordID;
            
            public TrieNode(){
                this.children = new TrieNode[26];
                this.wordID = -1;    
            }
        }
        
        private TrieNode root;
        
        public Trie(){
            root = new TrieNode();
        }
        
        private void add(TrieNode root, int i, String word, int wordID){
            
            int idx = word.charAt(i) - 'a';
            if(root.children[idx] == null) root.children[idx] = new TrieNode();
            
            if(i == word.length() - 1) // last character
                root.children[idx].wordID = wordID;
            else
                add(root.children[idx], i + 1, word, wordID);
        }
        
        public void add(String word, int wordID){
            add(root, 0, word, wordID);
        }
        
        private List<Integer> getPrefixes(TrieNode root, int i, String sentence){
            List<Integer> prefixes;
            
            if(root == null) return new ArrayList<>();            
            else if(i >= sentence.length()){                
                prefixes = new ArrayList<>();
                if(root.wordID != -1) prefixes.add(root.wordID);
                
                return prefixes;
            }
            
            int idx = sentence.charAt(i) - 'a';
            // if(root.children[idx] == null) prefixes = new ArrayList<>();
            // else 
                prefixes = getPrefixes(root.children[idx], i + 1, sentence);
            
            if(root.wordID != -1) prefixes.add(root.wordID);
            
            return prefixes;
        }
        
        public List<Integer> getPrefixes(int si, String sentence){
            return getPrefixes(root, si, sentence);
        }
    }
    
    private List<String> solve(int i, String s, List<String> dict, Trie trie){
        
        List<String> res = new ArrayList<>();
        if(i >= s.length()) {
            res.add("");
            return res;
        }
        
        List<Integer> prefixes = trie.getPrefixes(i, s);        
        if(prefixes.size() == 0) return null;
        
        for(int idx : prefixes){
            String word = dict.get(idx);
            List<String> rest = solve(i + word.length(), s, dict, trie);
            if(rest == null) continue;
 
            for(String st : rest){
                StringBuilder sb = new StringBuilder(word);
                
                if(st.length() > 0){
                    sb.append(' ');                
                    sb.append(st);
                }
                
                res.add(sb.toString());
            }
        }
        
        return res;
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        Trie trie = new Trie();
        int id = 0;
        for(String word : wordDict) 
            trie.add(word, id++);        
        
        List<String> ans = solve(0, s, wordDict, trie);
        if(ans == null) return new ArrayList<>();
        return ans;            
    }
}