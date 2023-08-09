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
    static final int DEL_LENGTH = 1001;
    static List<TreeNode> forest;
    
    public void solve(TreeNode root, boolean[] del){
        if(root == null) return;
        
        solve(root.left, del);
        solve(root.right, del);
        
        if(root.left != null && del[root.left.val]){
            if(root.left.left != null)
                forest.add(root.left.left);
            
            if(root.left.right != null)
                forest.add(root.left.right);
            
            root.left = null;
        }
        
        if(root.right != null && del[root.right.val]){
            if(root.right.left != null)
                forest.add(root.right.left);
            
            if(root.right.right != null)
                forest.add(root.right.right); 
            
            root.right = null;
        }                
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        forest = new LinkedList<>();
        if(root == null) return forest;
        
        boolean[] del = new boolean[DEL_LENGTH];
        for(int tree = 0; tree < to_delete.length; ++tree)
            del[to_delete[tree]] = true; 
        
        solve(root, del);
        if(del[root.val]){
            if(root.left != null)
                forest.add(root.left);
            
            if(root.right != null)
                forest.add(root.right);   
        } else
            forest.add(root);
        
        return forest;
    }
}