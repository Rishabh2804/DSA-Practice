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
    
    private static final List<Integer> NONE = new ArrayList<>();    
    private List<Integer> smallest = NONE;
    
    
    public String smallestFromLeaf(TreeNode root) {
        smallest = NONE;
        List<Integer> byteCode = new ArrayList<>();
        solve(root, byteCode);
        
        return parse(smallest);
    }
    
    private void solve(TreeNode root, List<Integer> byteCode){
        if(root == null) return;
        
        byteCode.add(root.val);
        
        if(root.left == null && root.right == null) {
            if(smallest == NONE) 
                smallest = new ArrayList<>(byteCode);
            else if(compare(smallest, byteCode) > 0) 
                smallest = new ArrayList<>(byteCode); 
            
            byteCode.remove(byteCode.size() - 1);
            return;
        }
        
        solve(root.left, byteCode);
        solve(root.right, byteCode);
        
        byteCode.remove(byteCode.size() - 1);
    }
    
    private String parse(List<Integer> seq){
        StringBuilder builder = new StringBuilder();
        for(int i : seq)
            builder.append((char)('a' + i));
        
        builder.reverse();
        return builder.toString();
    }
    
    private int compare(List<Integer> a, List<Integer> b){
        if(a == NONE) return 1;
        else if(b == NONE) return -1;
        
        int lim = Math.min(a.size(), b.size());
        
        for(int i = a.size() - 1, j = b.size() - 1; i >= 0 && j >= 0; --i, --j) {
            if(a.get(i) != b.get(j)) 
                return a.get(i) - b.get(j);                        
        }
        
        return a.size() - b.size();
    }            
}