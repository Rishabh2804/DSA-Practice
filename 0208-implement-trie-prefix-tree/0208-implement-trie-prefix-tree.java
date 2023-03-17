class Trie {

    static class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode(){
            isEnd = false;
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
        root.isEnd = true;
    }
    
    public void insert(String word) {
        insert(root, 0, word);
    }
    
    private void insert(TrieNode root, int i, String word){
        if(i >= word.length()){
            root.isEnd = true;
            return;
        }
        
        int childIdx = word.charAt(i) - 'a';
        if(root.children[childIdx] == null)
            root.children[childIdx] = new TrieNode();                
        
        insert(root.children[childIdx], i + 1, word);
    }
    
    public boolean search(String word) {
        return search(root, 0, word);   
    }
    
    private boolean search(TrieNode root, int i, String word){            
        if(i >= word.length())
            return root.isEnd;
        
        int childIdx = word.charAt(i) - 'a';
        if(root.children[childIdx] == null)
            return false;
        
        return search(root.children[childIdx], i + 1, word);        
    }
    
    public boolean startsWith(String prefix) {
        return startsWith(root, 0, prefix);
    }
    
    private boolean startsWith(TrieNode root, int i, String prefix){            
        if(i >= prefix.length())
            return true;
        
        int childIdx = prefix.charAt(i) - 'a';
        if(root.children[childIdx] == null)
            return false;
        
        return startsWith(root.children[childIdx], i + 1, prefix);        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */