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
    
    class Pair{
        int root;
        int noRoot;
        
        public Pair(int noRoot, int root){
            this.root = root;
            this.noRoot = noRoot;
        }        
    }
    
    int MIN_VALUE = -1000;
    
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        
        return solve(root).root;
    }
    
    public Pair solve(TreeNode root){
        if(root == null)
            return new Pair(MIN_VALUE, MIN_VALUE);
        
        Pair left = solve(root.left);
        Pair right = solve(root.right);

        // Not the root
        int lp = root.val + left.noRoot;
        int rp = root.val + right.noRoot;                
        int ans1 = Math.max(root.val, Math.max(lp, rp));
        
        // Is the root
        int lpr = lp + rp - root.val;
        int lORr = Math.max(left.root, right.root);
        int ans2 = Math.max(lpr, lORr);
        
        return new Pair(ans1, Math.max(ans1, ans2));
    }
}