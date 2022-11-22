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
    
    int count = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        
        count = k;
        return find(root);
    }
    
    public int find(TreeNode root){
        if(root == null)
            return -1;
        
        int leftAns = find(root.left);
        if(leftAns != -1)
            return leftAns;
                
        if(--count == 0)
            return root.val;
        
        int rightAns = find(root.right);
        if(rightAns != -1)
            return rightAns;
        else return -1;
    }
    
}