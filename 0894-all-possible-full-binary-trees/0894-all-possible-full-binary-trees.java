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
    public List<TreeNode> allPossibleFBT(int n) {            
        List<TreeNode> res = new LinkedList<>();
        if(n % 2 == 0) return res;

        if(n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
                
        int rest = n - 1;        
        for(int i = 1; i < rest; i += 2){
            List<TreeNode> leftFBTs = allPossibleFBT(i);
            List<TreeNode> rightFBTs = allPossibleFBT(rest - i);
            
            for(TreeNode left : leftFBTs){
                for(TreeNode right : rightFBTs){
                    TreeNode root = new TreeNode(0, left, right);                    
                    res.add(root);
                }
            }
        }
        
        return res;
    }
}