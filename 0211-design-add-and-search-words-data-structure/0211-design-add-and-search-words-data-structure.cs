public class TrieNode
{
    public TrieNode[] children;
    public bool isTerminating;

    public TrieNode()
    {
        children = new TrieNode[26];
        Array.Fill(children, null);
        isTerminating = false;
    }
}
public class WordDictionary
{

    TrieNode root;
    public WordDictionary()
    {
        root = new TrieNode();
        root.isTerminating = true;
    }

    private void Insert(TrieNode root, string word)
    {
        if (word.Length == 0)
        {
            root.isTerminating = true;
            return;
        }
        
        int childIndex = word[0] - 'a';
        if (root.children[childIndex] == null)
            root.children[childIndex] = new TrieNode();

        if (word.Length == 1)
        {
            root.children[childIndex].isTerminating = true;
            return;
        }

        Insert(root.children[childIndex], word.Substring(1));
    }
    public void AddWord(string word)
    {
        if (word.Length == 0)
            return;

        Insert(this.root, word);
    }

    private bool Search(TrieNode root, string word)
    {
        if (root == null)
            return false;

        if (word.Length == 0)
            return root.isTerminating;

        if (word[0] == '.')
        {
            foreach (TrieNode child in root.children)
            {
                if (Search(child, word.Substring(1)))
                    return true;
            }

            return false;
        }

        int childIndex = word[0] - 'a';
        if (root.children[childIndex] == null)
        {
            return false;
        }

        return Search(root.children[childIndex], word.Substring(1));
    }
    public bool Search(string word)
    {

        return Search(root, word);
    }
}
