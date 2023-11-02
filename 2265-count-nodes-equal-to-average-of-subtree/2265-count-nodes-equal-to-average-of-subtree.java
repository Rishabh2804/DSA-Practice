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
    static final int SUM = 0;
    static final int COUNT = 1;
    static final int ANS = 2;
    
    private int[] solve(TreeNode root){
        if(root == null) return new int[]{0, 0, 0};
        
        int[] left = solve(root.left);
        int[] right = solve(root.right);
        
        int sum = root.val + left[SUM] + right[SUM];
        int count = 1 + left[COUNT] + right[COUNT];
        int ans = left[ANS] + right[ANS];
        
        if(sum / count == root.val) 
            ans++;
        
        return new int[]{sum, count, ans};
    }
    
    public int averageOfSubtree(TreeNode root) {        
        return solve(root)[ANS];
    }
}