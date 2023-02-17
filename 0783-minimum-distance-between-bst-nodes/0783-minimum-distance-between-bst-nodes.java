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
    
    List<Integer> nodes;
    public int minDiffInBST(TreeNode root) {
        if(root == null)
            return 0;
        
        nodes = new ArrayList<>();                
        inorder(root);
        
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < nodes.size(); ++i)
            minDiff = Math.min(minDiff, nodes.get(i) - nodes.get(i - 1));
        
        return minDiff;
    }
    
    private void inorder(TreeNode root){
        if(root == null)
            return;
        
        inorder(root.left);
        nodes.add(root.val);
        inorder(root.right);        
    }
}