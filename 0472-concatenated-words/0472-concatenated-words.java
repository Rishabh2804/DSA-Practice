class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Trie root = new Trie();
        for(String word:words)
        {
            root.addWord(word);
        }
        for(String word:words)
        {
            if(root.checkWord(word,0,0))
                res.add(word);
        }

        return res;
    }
}

class Trie{
    TrieNode root;
    Trie()
    {
        root = new TrieNode();
    }

    class TrieNode
    {
        TrieNode[] child;
        boolean endOfWord;

        TrieNode()
        {
            child = new TrieNode[26];
            for(int i=0;i<26;i++)
            {
                child[i] = null;
            }
            endOfWord = false;
        }
    }

    void addWord(String key)
    {
        char[] keyArr = key.toCharArray();
        TrieNode curRoot = root;

        for(int i=0;i<keyArr.length;i++)
        {
            int curChar = keyArr[i]-'a';
            if(curRoot.child[curChar]==null)
            {
                curRoot.child[curChar] = new TrieNode();
            }
            curRoot = curRoot.child[curChar];
        }
        curRoot.endOfWord = true;
    }

    boolean checkWord(String key,int idx,int count)
    {
        if(idx==key.length())
        {
            return count>=2;
        }

        TrieNode curRoot = root;
        for(;idx<key.length();idx++)
        {
            int curChar = key.charAt(idx)-'a';
            if(curRoot.child[curChar]==null)
            {
                return false;
            }
            curRoot = curRoot.child[curChar];
            if(curRoot.endOfWord&&checkWord(key,idx+1,count+1))
            {
                return true;
            }
        }
        return false;
    }

}