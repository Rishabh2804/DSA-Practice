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
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null)
            return false;
        
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        
        int level = 1;
        while(!nodes.isEmpty()){
            int size = nodes.size();
            
            int pre;
            if(level % 2 == 0)
                pre = Integer.MAX_VALUE;
            else
                pre = Integer.MIN_VALUE;
                       
            for(int i = 0; i < size; ++i){                    
                TreeNode curr = nodes.poll();
                if(curr.val % 2 != level % 2)
                    return false;
                    
                if(level % 2 == 0 && curr.val >= pre)
                    return false;
                else if(level % 2 == 1 && curr.val <= pre)
                    return false;
                
                pre = curr.val;
                    
                if(curr.left != null)
                    nodes.add(curr.left);
                    
                if(curr.right != null)
                    nodes.add(curr.right);                    
            }     
            
            level = 1 - level;
        }
        
        return true;
    }
        
}