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
    
    private List<TreeNode> list;
    
    private void solve(TreeNode root, boolean[] dlt){
        if(root == null) return;
        
        if(dlt[root.val]){
            if(root.left != null && !dlt[root.left.val]) list.add(root.left);
            if(root.right != null && !dlt[root.right.val]) list.add(root.right);            
        }
        
        solve(root.left, dlt);
        solve(root.right, dlt);
        
        if(root.left != null && dlt[root.left.val]) root.left = null;
        if(root.right != null && dlt[root.right.val]) root.right = null;
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        list = new ArrayList<>();
        boolean[] dlt = new boolean[1001];
        for(int i : to_delete) dlt[i] = true;
        
        solve(root, dlt);
        if(root != null && !dlt[root.val]) list.add(root);
        
        return list;
    }
}