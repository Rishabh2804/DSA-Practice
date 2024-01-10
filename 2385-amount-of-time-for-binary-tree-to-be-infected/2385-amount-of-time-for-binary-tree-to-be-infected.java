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
    
    // Domain range : [1, 1e5]
    // 2 ^ 17 > 10^5, easily maskable for infection detection
    static final int INFECTED = 1 << 17;
    
    private int startPos;
    private int maxDist;
    
    private final int infectValue(int val){
        return val | INFECTED;
    }
    
    private final int disinfectValue(int val){
        return val & ~INFECTED;
    }
    
    private int helper(TreeNode root, int start, int currDist, boolean infected){
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            if(root.val == start) return INFECTED;
            return 0;
        }
        
        int leftDist = 1 + helper(root.left, start, currDist + 1, infected);
        int rightDist = 1 + helper(root.right, start, currDist + 1, infected);;
        
        if((leftDist & INFECTED) != 0){
            maxDist = Math.max(maxDist, disinfectValue(leftDist));
            if(root.right != null)
            maxDist = Math.max(maxDist, disinfectValue(leftDist + rightDist));
            
            return leftDist;
        } else if((rightDist & INFECTED) != 0){
            maxDist = Math.max(maxDist, disinfectValue(rightDist));
            if(root.left != null)
            maxDist = Math.max(maxDist, disinfectValue(leftDist + rightDist));
            
            return rightDist;
        }
        
        maxDist = Math.max(maxDist, Math.max(disinfectValue(leftDist), disinfectValue(rightDist)));
        
        if(root.val == start) return INFECTED;
        
        return Math.max(leftDist, rightDist);        
    }
    
    public int amountOfTime(TreeNode root, int start) {
        if(root == null) return 0;
        
        maxDist = 0;
        helper(root, start, 0, false);        

        return disinfectValue(maxDist);
    }
}