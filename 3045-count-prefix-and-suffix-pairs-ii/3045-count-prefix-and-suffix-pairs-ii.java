class Solution {
    
    static class Trie {
        
        static class TrieNode {
            int terminatingIDs;
            TrieNode[] children;
            
            public TrieNode(){
                // terminatingIDs = new ArrayList<>();
                terminatingIDs = -1;
                children = new TrieNode[26];                
            }            
        }
        
        TrieNode prefix;
        TrieNode suffix;
        
        HashMap<Integer, Integer> freq;
        HashMap<String, Integer> idMap;
        
        public Trie(){
            this.prefix = new TrieNode();
            this.suffix = new TrieNode();
            
            freq = new HashMap<>();
            idMap = new HashMap<>();
        }
        
        private void insert(TrieNode root, int i, String word, int currID, HashMap<Integer, Boolean> ids, boolean flag){
            
            if(root.terminatingIDs != -1){
                if(flag) ids.put(root.terminatingIDs, false);
                else if(ids.containsKey(root.terminatingIDs)) ids.put(root.terminatingIDs, true);                
            }
            
            if(i >= word.length()){ 
                root.terminatingIDs = currID;
                return;
            }
            
            int idx = word.charAt(i) - 'a';
            
            if(root.children[idx] == null) root.children[idx] = new TrieNode();
                        
            insert(root.children[idx], i + 1, word, currID, ids, flag);
        }
        
        private String reverse(String word){
            StringBuilder sb = new StringBuilder(word);
            return sb.reverse().toString();
        }
        
        public long insert(String word){
                        
            idMap.putIfAbsent(word, idMap.size() + 1);
            
            int id = idMap.get(word);
            
            HashMap<Integer, Boolean> map = new HashMap<>();

            insert(prefix, 0, word, id, map, true);                        
            insert(suffix, 0, reverse(word), id, map, false);
            
            long count = 0;
            for(Integer key : map.keySet()) {
                Boolean val = map.get(key);
                if(val != null && val == true) {
                    count += 1L * freq.get(key);
                }
            }
            
            freq.put(id, freq.getOrDefault(id, 0) + 1);
            
            return count;
        }
    }
    
    public long countPrefixSuffixPairs(String[] words) {
        
        Trie trie = new Trie();
        long count = 0;
        for(String word : words){
            count += trie.insert(word);
        }
        
        return count;
    }
}