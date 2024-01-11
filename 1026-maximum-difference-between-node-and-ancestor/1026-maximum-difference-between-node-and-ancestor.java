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
    
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 100000;
    
    private static final int MIN = 0;
    private static final int MAX = 1;    
    private static final int DIFF = 2;
    
    private int[] solve(TreeNode root){
        if(root == null) return new int[]{MAX_VALUE, MIN_VALUE, 0};
        
        int[] left = solve(root.left);
        int[] right = solve(root.right);
        
        int min = Math.min(root.val, Math.min(left[MIN], right[MIN]));
        int max = Math.max(root.val, Math.max(left[MAX], right[MAX]));
        
        int maxDiff = Math.max(left[DIFF], right[DIFF]);
        maxDiff = Math.max(maxDiff, 
                           Math.max(
                               Math.abs(root.val - min), 
                               Math.abs(max - root.val)
                           ));
        
        return new int[]{min, max, maxDiff};
    }
    
    public int maxAncestorDiff(TreeNode root) {
        return solve(root)[DIFF];        
    }
}