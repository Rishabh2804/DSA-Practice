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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    public int sumNumbers(TreeNode root, int sumTillNow){
        if(root == null)
            return 0;
        
        sumTillNow = sumTillNow * 10 + root.val;
        
        if(root.left == null && root.right == null)
            return sumTillNow;
        
        return sumNumbers(root.left, sumTillNow) + sumNumbers(root.right, sumTillNow);
    }    
}