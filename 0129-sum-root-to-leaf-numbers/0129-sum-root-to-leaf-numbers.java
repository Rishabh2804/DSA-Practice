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
    
    int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return sum;
    }
    
    public void sumNumbers(TreeNode root, int sumTillNow){
        if(root == null)
            return;
        
        sumTillNow = sumTillNow * 10 + root.val;
        
        if(root.left == null && root.right == null)
            sum += sumTillNow;
        
        sumNumbers(root.left, sumTillNow);
        sumNumbers(root.right, sumTillNow);
    }    
}