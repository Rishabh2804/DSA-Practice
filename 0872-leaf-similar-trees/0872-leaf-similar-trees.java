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
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafSeq1 = new ArrayList<>();
        List<Integer> leafSeq2 = new ArrayList<>();

        getLeafSeq(root1, leafSeq1);
        getLeafSeq(root2, leafSeq2);
        
        return leafSeq1.equals(leafSeq2);
    }
    
    public void getLeafSeq(TreeNode root, List<Integer> leafSeq){
        if(root == null)
            return;
        
        if(root.left == null && root.right == null){
            leafSeq.add(root.val);
            return;            
        }
        
        getLeafSeq(root.left, leafSeq);
        getLeafSeq(root.right, leafSeq);
    }
    
//     public boolean isIdentical(ArrayList<Integer> list1, ArrayList<Integer> list2){
//         if(list1.size() != list2.size())
//             return false;
        
//         for(int i = 0; i < list1.size(); ++i){
//             if(list1.get(i) != list2.get(i))
//                 return false;
//         }
        
//         return true;
//     }

    
}