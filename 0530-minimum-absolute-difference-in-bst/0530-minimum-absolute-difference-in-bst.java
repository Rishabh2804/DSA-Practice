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
    static final int MAX_VALUE = 1000000;
    static final int MIN_VALUE = -1;
    
    static class Pair{
        int low;
        int high;
        int diff;
        
        public Pair(int l, int h, int diff){
            high = h;
            low = l;
            this.diff = diff;
        }
    }
    
    public Pair solve(TreeNode root){
        if(root == null)
            return new Pair(MAX_VALUE, MIN_VALUE, MAX_VALUE);
        
        // if(root.left == null && root.right == null)
        //     return new Pair(root.val, root.val, 0);
        
        int leftDiff = MAX_VALUE;
        int low = root.val;
        if(root.left != null) {
            Pair left = solve(root.left);
            leftDiff = Math.min(left.diff, root.val - left.high);
            low = left.low;
        }
    
        int rightDiff = MAX_VALUE;
        int high = root.val;
        if(root.right != null) {
            Pair right = solve(root.right);
            rightDiff = Math.min(right.diff, right.low - root.val);
            high = right.high;
        }
        
        int minDiff = Math.min(leftDiff, rightDiff);
        return new Pair(low, high, minDiff);
    }
    
    public int getMinimumDifference(TreeNode root) {
        return solve(root).diff;
    }
}