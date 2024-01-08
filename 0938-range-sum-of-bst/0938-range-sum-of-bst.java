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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
        
        if(low <= root.val && root.val <= high) {
            return root.val + 
                   rangeSumBST(root.left, low, root.val) + 
                   rangeSumBST(root.right, root.val, high);
        }
        else if(high < root.val)
            return rangeSumBST(root.left, low, high);
        else 
            return rangeSumBST(root.right, low, high);        
    }
}