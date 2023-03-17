class Trie {
    
    boolean isEnd;
    Trie[] children;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
    
    public void insert(String word) {
        insert(word, 0);
    }

    private void insert(String word, int i) {
        if (i == word.length()) {
            isEnd = true;
            return;
        }

        char c = word.charAt(i);

        if (children[c - 'a'] == null) {
            children[c - 'a'] = new Trie();
        }

        children[c - 'a'].insert(word, i + 1);
    }
    
    public boolean search(String word) {
        return search(word, 0);
    }

    private boolean search(String word, int i) {
        if (word.length() == i) {
            return isEnd;
        }

        char c = word.charAt(i);

        if (children[c - 'a'] == null) {
            return false;
        }

        return children[c - 'a'].search(word, i + 1);
    }
    
    public boolean startsWith(String prefix) {
        return startsWith(prefix, 0);
    }

    private boolean startsWith(String word, int i) {
        if (word.length() == i) {
            return true;
        }

        char c = word.charAt(i);

        if (children[c - 'a'] == null) {
            return false;
        }

        return children[c - 'a'].startsWith(word, i + 1);
    }
    
}