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
    static int count = 0;    
    HashMap<Long, Integer> set;
    
    public void solve(TreeNode root, long sum, int targetSum){
        if(root == null) return;
        
        sum += root.val;
        
        set.put(sum, set.getOrDefault(sum, 0) + 1);
        
        count += set.getOrDefault(sum - targetSum, 0); 
        if(targetSum == 0)
            count --;
        
        solve(root.left, sum, targetSum);
        solve(root.right, sum, targetSum);

        set.put(sum, set.getOrDefault(sum, 0) - 1);
        if(set.get(sum) == 0) set.remove(sum);
        
        sum -= root.val;
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        set = new HashMap<>();
        set.put(0L, 1);
        
        solve(root, 0L, targetSum);
        return count;
    }
}