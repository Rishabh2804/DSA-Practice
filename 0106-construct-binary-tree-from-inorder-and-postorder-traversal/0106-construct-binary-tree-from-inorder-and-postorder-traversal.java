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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder.length == 0){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        
        int n = 0;
        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == root.val) {
                n = i;
                break;
            }
        }

        int[] leftin = new int[n];
        int[] rightin = new int[inorder.length - n - 1];

        for (int i = 0; i < inorder.length; ++i) {
            if (i == n)
                continue;

            if (i < n)
                leftin[i] = inorder[i];
            else
                rightin[i - n - 1] = inorder[i];

        }

        int[] leftpost = new int[n];
        int[] rightpost = new int[postorder.length - 1 - n];

        for (int i = 0; i < postorder.length - 1; ++i) {
            if (i < n)
                leftpost[i] = postorder[i];
            else
                rightpost[i - n] = postorder[i];
        }

        root.left = buildTree(leftin, leftpost);
        root.right = buildTree(rightin, rightpost);
        return root;

    }
}