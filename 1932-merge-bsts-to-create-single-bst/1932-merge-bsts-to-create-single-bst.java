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
    
    static class Box{
        int low;
        int high;
        boolean isBST;
        
        Box(int low, int high, boolean isBST){
            this.low = low;
            this.high = high;
            this.isBST = isBST;
        }
    }
    
    private Box isBST(TreeNode root){
        if(root == null) return new Box(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        
        Box curr = new Box(root.val, root.val, false);
        
        Box left = isBST(root.left);
        if(!left.isBST || left.high >= root.val) return curr;
        else curr.low = Math.min(curr.low, left.low);
        
        Box right = isBST(root.right);
        if(!right.isBST || right.low <= root.val) return curr;
        else curr.high = Math.max(curr.high, right.high);
        
        curr.isBST = true;
        return curr;
    }
    
    void dfs(TreeNode root, int i, List<TreeNode> trees, HashMap<Integer, Integer> nodes){
        if(root == null) return;
            
        // checking leaf node
        if(root.left == null && root.right == null) {
            Integer idx = nodes.get(root.val);
            if(idx == null) return;
            
            TreeNode rep = trees.get(idx);
            root.left = rep.left;
            root.right = rep.right;
            
            nodes.remove(root.val);
            trees.set(idx, null);
            
            if(idx < i) return; // would have been already traversed
        }
        
        dfs(root.left, i, trees, nodes);
        dfs(root.right, i, trees, nodes);
    }
    
    public TreeNode canMerge(List<TreeNode> trees) {
        HashMap<Integer, Integer> nodes = new HashMap<>();
        
        int k = 0;
        for(TreeNode root : trees)
            nodes.put(root.val, k++);
        
        TreeNode ans = null;
        for(int i = 0; i < trees.size(); ++i){   
            if(trees.get(i) == null) continue;
            
            // temporarily marking visited
            TreeNode curr = trees.get(i);    
            nodes.remove(curr.val);
            
            dfs(curr, i, trees, nodes);
            ans = trees.get(i);                        
            
            nodes.put(curr.val, i);
        }
        
        if(nodes.size() > 1) return null;        
        
        if(isBST(ans).isBST) return ans;
        else return null;
    }
}