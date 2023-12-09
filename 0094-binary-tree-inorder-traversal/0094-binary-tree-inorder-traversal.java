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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();  
        
        if(root == null)
            return traversal;
        
        traverse(root, traversal);
        return traversal;
    }
    
    public void traverse(TreeNode root, List<Integer> traversal){
        if(root == null)
            return;
        
        traverse(root.left, traversal);
        traversal.add(root.val);
        traverse(root.right, traversal);
    }
}