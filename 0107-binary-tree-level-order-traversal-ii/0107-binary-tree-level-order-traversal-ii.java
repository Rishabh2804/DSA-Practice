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
        
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList<>();
        if(root == null) return levelOrder;
        
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        
        while(!nodes.isEmpty()){
            int size = nodes.size();
            
            List<Integer> values = new ArrayList<>();
            while(size --> 0){
                TreeNode curr = nodes.poll();
                values.add(curr.val);
                
                if(curr.left != null) nodes.add(curr.left);
                if(curr.right != null) nodes.add(curr.right);                
            }
            
            levelOrder.add(values);
        }
        
        Collections.reverse(levelOrder);
        return levelOrder;
    }
}