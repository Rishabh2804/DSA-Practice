/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    HashMap<String, List<TreeNode>> hashes;
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        hashes = new HashMap<>();    
        List<TreeNode> duplicates = new ArrayList<>();
        
        getHash(root);
        for(String hash : hashes.keySet()){
            if(hashes.get(hash).size() > 1)
                duplicates.add(hashes.get(hash).get(0));
        }
        
        return duplicates;
    }        
    
    public StringBuilder getHash(TreeNode root){
        if(root == null)
            return null;
        
        StringBuilder curr = new StringBuilder("" + root.val);
        
        if(root.left == null && root.right == null){
            List<TreeNode> nodes = hashes.getOrDefault(curr.toString(), new ArrayList<>());
            if(nodes.size() < 2)
                nodes.add(root);
            hashes.put(curr.toString(), nodes);
            
            return curr;        
        }
        
        StringBuilder left = getHash(root.left);
        StringBuilder right = getHash(root.right);
        
        curr.append("[");
        if(left != null)
            curr.append(left.toString());
        if(right != null)
            curr.append("," + right.toString());
        curr.append("]");
        
        List<TreeNode> nodes = hashes.getOrDefault(curr.toString(), new ArrayList<>());
        if(nodes.size() < 2)
            nodes.add(root);
        hashes.put(curr.toString(), nodes);

        return curr;
    }
}