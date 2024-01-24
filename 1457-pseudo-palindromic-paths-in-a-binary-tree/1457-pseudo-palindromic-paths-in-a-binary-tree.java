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
    
    private int toMask(int n){
        if(n == 0) return 0;
        else return 1 << (n - 1);
    }
    
    private boolean isPalindrome(int mask){
        // odd length palindrome  -->  mask would be power of 2, e.g., 100, 010, 001
        // even length palindrome --> mask would be 0
        
        // 100 --> 100 & 011 = 0
        // 010 --> 010 & 001 = 0
        //   0 --> 000 & 111 = 0
        return (mask & (mask - 1)) == 0;
    }
    
    private int solve(int currMask, TreeNode root){
        if(root == null) return 0;
        
        currMask ^= toMask(root.val);
        
        if(root.left == null && root.right == null)
            return isPalindrome(currMask) ? 1 : 0;            
        
        return solve(currMask, root.left) + solve(currMask, root.right);
    }
    
    public int pseudoPalindromicPaths (TreeNode root) {
        return solve(0, root);
    }
}