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
    
    static class Triplet{
        int maxDiff;
        int min;
        int max;
        
        public Triplet(int maxDiff, int min, int max){
            this.maxDiff = maxDiff;
            this.min = min;
            this.max = max;         
        }            
    }
    
    public Triplet solve(TreeNode root){
        if(root == null)
            return new Triplet(0, 0, 0);
        
        if(root.left == null && root.right == null)
            return new Triplet(0, root.val, root.val);
        
        int maxDiff = 0;
        int min = root.val;
        int max = root.val;
        
        if(root.left != null){
            Triplet left = solve(root.left);
            maxDiff = Math.max(maxDiff, left.maxDiff);
            maxDiff = Math.max(maxDiff, Math.abs(root.val - left.min));
            maxDiff = Math.max(maxDiff, Math.abs(root.val - left.max));
            
            min = Math.min(min, left.min);
            max = Math.max(max, left.max);            
        }
        
        if(root.right != null){
            Triplet right = solve(root.right);
            maxDiff = Math.max(maxDiff, right.maxDiff);
            maxDiff = Math.max(maxDiff, Math.abs(root.val - right.min));
            maxDiff = Math.max(maxDiff, Math.abs(root.val - right.max));
            
            min = Math.min(min, right.min);
            max = Math.max(max, right.max);            
        }
        
        return new Triplet(maxDiff, min, max);
    }
    
    public int maxAncestorDiff(TreeNode root) {
        if(root == null)    
            return 0;
        
        return solve(root).maxDiff;
    }
        
}