/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    // static int exeRound = 1;
    // int[] copied = new int[100];
    Node[] nodes = new Node[100];
    
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        
        // exeRound++;        
        return clone(node);
    }
    
    public Node clone(Node node){
        // if(copied[node.val - 1] == exeRound)
        //     return nodes[node.val - 1];
        
        if(nodes[node.val - 1] != null)
            return nodes[node.val - 1];

        Node root = new Node(node.val);
        // copied[node.val - 1] = exeRound;
        nodes[node.val - 1] = root;
        
        for(Node neighbor : node.neighbors){
            Node clonedNeighbor = clone(neighbor);
            if(clonedNeighbor == null)
                continue;
            
            root.neighbors.add(clonedNeighbor);
        }
        
        return root;
    }
}