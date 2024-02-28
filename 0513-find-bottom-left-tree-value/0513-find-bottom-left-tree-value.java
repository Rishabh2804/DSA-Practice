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
    public int findBottomLeftValue(TreeNode root) {
        
        if(root == null) return 0;
        
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        
        int leftMost = root.val;
        while(!nodes.isEmpty()){
            leftMost = nodes.peek().val;
            
            int size = nodes.size();
            while(size --> 0){
                TreeNode curr = nodes.poll();
                
                if(curr.left != null) nodes.add(curr.left);
                if(curr.right != null) nodes.add(curr.right);
            }
        }
        
        return leftMost;        
    }
}