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
    static final int ZIG = 0;
    static final int ZAG = 1;
    int maxLen;
    
    public void solve(TreeNode root, int pat, int count){
        if(root == null)
            return;
        
        maxLen = Math.max(maxLen, count);
        
        if(pat == ZIG){
            solve(root.left, ZAG, count + 1);
            solve(root.right, ZIG, 1);
        } else{
            solve(root.left, ZAG, 1);
            solve(root.right, ZIG, count + 1);
        }        
    }
    
    public int longestZigZag(TreeNode root) {
        maxLen = 0;    
        solve(root, ZIG, 0);
        solve(root, ZAG, 0);
        
        return maxLen;
    }
}