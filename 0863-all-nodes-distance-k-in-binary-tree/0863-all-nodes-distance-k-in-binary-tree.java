/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    static final int UNREACHABLE = Integer.MAX_VALUE;
    
    public List<Integer> nodes;
    
    private int solve(TreeNode root, TreeNode target, int k){
        if(root == null) return UNREACHABLE; // unreachable, hence infinite distance
        
        if(target == null){
            if(k == 0){
                nodes.add(root.val);
            } else {
                solve(root.left, target, k - 1);
                solve(root.right, target, k - 1);
            }
            return UNREACHABLE;
        }

        if(root == target) {
            solve(root, null, k);
            return 0;   // distance 0 from self
        }
        
        int leftDist = solve(root.left, target, k);
        int rightDist = solve(root.right, target, k);

        if(leftDist != UNREACHABLE) {
            int reqDist = k - leftDist - 1;
            if(reqDist == 0)
                nodes.add(root.val);                                   
            else
                solve(root.right, null, reqDist - 1);
            
            return leftDist + 1;
        } else if(rightDist != UNREACHABLE) {
            int reqDist = k - rightDist - 1;
            if(reqDist == 0)
                nodes.add(root.val);                                   
            else
                solve(root.left, null, reqDist - 1);
            
            return rightDist + 1;
        } else return UNREACHABLE;        
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        nodes = new LinkedList<Integer>();
        solve(root, target, k);
        return nodes;
    }
}