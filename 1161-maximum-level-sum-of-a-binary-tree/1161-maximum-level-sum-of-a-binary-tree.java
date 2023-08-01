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
    public int maxLevelSum(TreeNode root) {        
        
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        
        int maxSum = root.val;
        
        int level = 1;
        int counter = 1;
        
        while(!nodes.isEmpty()){
            int size = nodes.size();
            
            int sum = 0;
            while(size --> 0){
                TreeNode curr = nodes.poll();
                sum += curr.val;
                
                if(curr.left != null)
                    nodes.add(curr.left);
                
                if(curr.right != null)
                    nodes.add(curr.right);
            }
            
            if(sum > maxSum) {
                level = counter;
                maxSum = sum;
            }
            
            counter++;
        }
        
        return level;
    }
}