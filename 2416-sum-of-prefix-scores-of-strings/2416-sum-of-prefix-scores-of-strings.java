class TrieNode {
    TrieNode[] children;
    int words;
    
    public TrieNode(){
        children = new TrieNode[26];
        words = 0;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    private void add(TrieNode root, String key, int si) {
        if (si >= key.length())
            return;

        int childIndex = key.charAt(si) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode();
            root.children[childIndex] = child;
        }

        child.words++;

        add(child, key, si + 1);
    }

    public void add(String word) {
        add(this.root, word, 0);
    }
    
    // analogous to creating prefix sum array out of normal array
    private void transformTrie(TrieNode root, int prevScore){
        if(root == null) return;
        
        root.words += prevScore;
        prevScore = root.words;
        
        for(TrieNode child : root.children){
            if (child != null) 
                transformTrie(child, prevScore);
        }
    }
    
    public void transformTrie(){
        transformTrie(root, 0);        
    }
    
    // search for a word, and return its 'words' value
    private int getPrefixCount(TrieNode root, String key, int si) {
        if (si >= key.length()) 
            return root.words;

        int childIndex = key.charAt(si) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null)
            return 0;
        else 
            return getPrefixCount(child, key, si + 1);        
    }

    public int getPrefixCount(String word) {
        return getPrefixCount(root, word, 0);
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        
        Trie trie = new Trie();
        for(String word : words)
            trie.add(word);
        
        trie.transformTrie();
        
        int[] scores = new int[words.length];
        int i = 0;        
        for(String word : words)
            scores[i++] = trie.getPrefixCount(word);
        
        return scores;
    }
}