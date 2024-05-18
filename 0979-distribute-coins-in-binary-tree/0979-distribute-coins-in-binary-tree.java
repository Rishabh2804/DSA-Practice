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
    public int distributeCoins(TreeNode root) {
        if(root == null) return 0;
        
        int left = distributeCoins(root.left);
        int right = distributeCoins(root.right);
        
        if(root.left != null) root.val += root.left.val - 1;
        if(root.right != null) root.val += root.right.val - 1;
        
        return left + right + Math.abs(root.val - 1);
    }
}