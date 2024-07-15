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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> nodes = new HashMap<>();
        HashMap<Integer, Boolean> isRoot = new HashMap<>();
        
        for(int[] desc : descriptions){
            int rootVal = desc[0];
            int childVal = desc[1];
            boolean isLeft = desc[2] == 1;
            
            isRoot.putIfAbsent(rootVal, true);
            isRoot.put(childVal, false);
            
            nodes.putIfAbsent(rootVal, new TreeNode(rootVal));
            nodes.putIfAbsent(childVal, new TreeNode(childVal));
            
            TreeNode root = nodes.get(rootVal);
            TreeNode child = nodes.get(childVal);
            
            if(isLeft) root.left = child;
            else root.right = child;            
        }
        
        for(Integer val : isRoot.keySet()) {
            if(isRoot.get(val)) 
                return nodes.get(val);
        }
        
        return null;
    }
}