class Solution {
    
    static class Trie{
        // This trie implementation is analogous to a linked list
        // No branching is done to minimize memory consumption,
        // avoiding addition of and discardng branched subtrees
        
        static class Node{
            // maintaining only single child 
            // to store prefix characters only
            Node child; 
            char val; // character value of current node

            Node() {}
            Node(char val){
                this.val = val;
            }
        }
    
        static final Node TERMINATOR = new Node('#');
        Node root;
        Trie(){
            root = new Node();    
        }
        
        private void add(Node root, int i, String word){
            if(i >= word.length()) {  
                root.child = TERMINATOR; // rest of subtree is not needed
                return;
            }

            if(root.child == null)
                root.child = new Node(word.charAt(i));

            if(root.child.val == word.charAt(i))
                add(root.child, i + 1, word);
            else {
                // need of branching, so we would discard
                // the entire subtree as no common prefix 
                // is deductibile from this point
                root.child = TERMINATOR;
            }                         
        }
        
        void add(String word){
            add(root, 0, word);
        }
                
        String getLCP(){
            
            StringBuilder prefix = new StringBuilder();
            Node temp = root.child;
            while(temp != null && temp != TERMINATOR){
                prefix.append(temp.val);
                temp = temp.child;
            }
            
            return prefix.toString();
        }                
    }
    
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for(String str : strs)
            trie.add(str);
        
        return trie.getLCP();        
    }
}