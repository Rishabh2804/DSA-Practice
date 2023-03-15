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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null)
            return true;
        
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        
        boolean nullFound = false;
        while(!nodes.isEmpty()){
            int size = nodes.size();
            
            while(size --> 0){
                TreeNode curr = nodes.poll();
                
                if(curr.left == null)
                    nullFound = true;
                else if(nullFound)
                    return false;
                else nodes.add(curr.left);
                
                if(curr.right == null)
                    nullFound = true;
                else if(nullFound)
                    return false;
                else nodes.add(curr.right);
            }
        }
        
        return true;
    }
}