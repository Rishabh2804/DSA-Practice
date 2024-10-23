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
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        long nextSum = root.val;

        while (!queue.isEmpty()) {
            int size = queue.size();

            long temp = 0;
            ArrayList<TreeNode> list = new ArrayList<>();
            while (size-- > 0) {
                int leftSum = 0;
                int rightSum = 0;
                TreeNode node = queue.poll();
                list.add(node);

                if (node.left != null) {
                    leftSum = node.left.val;
                    queue.add(node.left);
                }

                if (node.right != null) {
                    rightSum = node.right.val;
                    queue.add(node.right);
                }

                temp += leftSum + rightSum;
                if (node.left != null)
                    node.left.val = leftSum + rightSum;

                if (node.right != null)
                    node.right.val = leftSum + rightSum;
            }

            for (TreeNode node : list) {
                node.val = (int) nextSum - node.val;
            }

            nextSum = temp;
        }
        return root;
    }
}