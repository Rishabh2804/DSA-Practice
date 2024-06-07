class Solution {
    
    static class Trie{
        static class TrieNode {
            int wordId;
            TrieNode[] children;
            
            TrieNode(){
                wordId = -1;
                children = new TrieNode[26];
            }
        }
        
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        
        private void add(TrieNode root, int i, String word, int wordId){
            if(i >= word.length()) {
                root.wordId = wordId;
                return;
            }
            
            int childIdx = word.charAt(i) - 'a';
            if(root.children[childIdx] == null) 
                root.children[childIdx] = new TrieNode();
            
            add(root.children[childIdx], i + 1, word, wordId);            
        }
        
        public void add(String word, int wordId){
            add(root, 0, word, wordId);
        }
        
        private int find(TrieNode root, int i, String word){
            if(root == null || i >= word.length()) return -1;            
            if(root.wordId != -1) return root.wordId;
            
            int childIdx = word.charAt(i) - 'a';
            return find(root.children[childIdx], i + 1, word);
        }
        
        public int find(String word){
            return find(root, 0, word);
        }
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        
        Trie trie = new Trie();
        for(int i = 0; i < dictionary.size(); ++i)
            trie.add(dictionary.get(i), i);
        
        StringBuilder sb = new StringBuilder();
        
        String[] words = sentence.split(" ");
        for(int i = 0; i < words.length; ++i){
            int pos = trie.find(words[i]);
            if(pos != -1) sb.append(dictionary.get(pos));
            else sb.append(words[i]);
            
            if(i < words.length - 1) sb.append(' ');
        }
        
        return sb.toString();
    }
}