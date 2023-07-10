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
    private int solve(TreeNode root){
        if(root == null) return Integer.MAX_VALUE;
        else if(root.left == null && root.right == null) return 1;        
        else return 1 + Math.min(solve(root.left), solve(root.right));
    }
    
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        else return solve(root);
    }
}