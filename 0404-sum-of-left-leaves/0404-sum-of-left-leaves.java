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
    
    private boolean isLeaf(TreeNode root){
        if(root == null) return false;
        return root.left == null && root.right == null;
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        
        int sum = sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        if(isLeaf(root.left)) sum += root.left.val;
        // if(!isLeaf(root.right)) sum += sumOfLeftLeaves(root.right);
        
        return sum;
    }
}