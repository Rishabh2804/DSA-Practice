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
    
    static final int DIA = 0;
    static final int HEIGHT = 1;
    
    int[] solve(TreeNode root){
        if(root == null) return new int[]{0, 0};
        
        int[] left = solve(root.left);
        int[] right = solve(root.right);
        
        int height = 1 + Math.max(left[HEIGHT], right[HEIGHT]);
        int diameter = left[HEIGHT] + right[HEIGHT];
        diameter = Math.max(diameter, Math.max(left[DIA], right[DIA]));
        
        return new int[] {diameter, height};
    }
        
    public int diameterOfBinaryTree(TreeNode root) {
        return solve(root)[DIA];
    }
}