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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if(n == 0){
            ans.add(null);
            return ans;
        }            
        
        for(int i = 1; i <= n; ++i){
            List<TreeNode> preAns = generateTrees(i - 1);
            List<TreeNode> postAns = generateTrees(n - i);
                
            for(TreeNode left : preAns){
                for(TreeNode right : postAns) {
                    TreeNode root = new TreeNode(i);

                    root.left = left;                                    
                    root.right = clone(right, i);

                    ans.add(root);
                }
            }
        }

        return ans;
    }

    public TreeNode clone(TreeNode root, int k){
        if(root == null)
            return null;

        TreeNode cloned = new TreeNode(root.val + k);
        cloned.left = clone(root.left, k);
        cloned.right = clone(root.right, k);

        return cloned;
    }
}