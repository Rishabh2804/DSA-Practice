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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        
        if(root == null) return values;
        
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        
        while(!nodes.isEmpty()){
            int size = nodes.size();
            int maxVal = Integer.MIN_VALUE;
            
            while(size --> 0){
                TreeNode curr = nodes.poll();
                maxVal = Math.max(maxVal, curr.val);
                
                if(curr.left != null) nodes.add(curr.left);
                if(curr.right != null) nodes.add(curr.right);
            }
            
            values.add(maxVal);
        }
        
        return values;
    }
}