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
    int totalSum;
    long product;
    
    int mod = 1000000007;
    
    public int maxProduct(TreeNode root) {
        if(root == null)
            return 0;
        
        totalSum = 0;
        product = 1L;
        
        sumTree(root);
        solve(root);
        
        return (int)(product % mod);
    }
    
    public void sumTree(TreeNode root){
        if(root == null)
            return;
        
        totalSum += root.val;
        
        sumTree(root.left);
        sumTree(root.right);
    }
    
    public int solve(TreeNode root){
        if(root == null)
            return 0;
                    
        int subTreeSum = root.val + solve(root.left) + solve(root.right);        
        int restSum = totalSum - subTreeSum;
        
        long currProduct = (long) subTreeSum * restSum;        
        product = Math.max(product, currProduct);
        
        return subTreeSum;
    }   
    
}