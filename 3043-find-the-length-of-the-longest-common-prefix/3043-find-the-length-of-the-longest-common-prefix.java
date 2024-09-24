class Solution {
    static class Trie{
        static class TrieNode {
            boolean vis;            
            TrieNode[] children;
            
            public TrieNode(){
                vis = false;
                children = new TrieNode[10];
            }
        }
        
        TrieNode root;
        
        public Trie(){
            root = new TrieNode();
        }
        
        private String toString(int n){                        
            return "" + n;
        }
            
        private void insert(int i, String num, TrieNode root){            
            if(i >= num.length()) return;
            
            int idx = num.charAt(i) - '0';
            if(root.children[idx] == null) root.children[idx] = new TrieNode();
            
            insert(i + 1, num, root.children[idx]);        
        }
        
        public void insert(int num){            
            insert(0, toString(num), root);
        }
        
        private int depth(int i, String num, TrieNode root){
            if(i >= num.length()) return num.length();

            int idx = num.charAt(i) - '0';
            if(root.children[idx] == null) return i;
            
            return depth(i + 1, num, root.children[idx]);
        }

        public int depth(int num){
            return depth(0, toString(num), root) ;
        }                
    }
    
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        
        Trie trie = new Trie();
        for(int n : arr1) trie.insert(n);
        
        int maxLen = 0;
        for(int n : arr2){
            maxLen = Math.max(maxLen, trie.depth(n));
        }
        
        return maxLen;
    }
}