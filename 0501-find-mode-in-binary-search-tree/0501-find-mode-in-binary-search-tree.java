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
    
    private static HashMap<Integer, Integer> values;
    
    private void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);
        values.put(root.val, values.getOrDefault(root.val, 0) + 1);
        inorder(root.right);        
    }
    
    public int[] findMode(TreeNode root) {
        values = new HashMap<>();
        
        inorder(root);
        
        List<Integer> res = new ArrayList<>();
        int maxFreq = 0;
        for(Integer val : values.keySet()){
            if(maxFreq < values.get(val)){
                maxFreq = values.get(val);
                res = new ArrayList<>();
            }
            
            if(maxFreq == values.get(val))
                res.add(val);
        }
        
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); ++i)
            ans[i] = res.get(i);
        
        return ans;
    }
}