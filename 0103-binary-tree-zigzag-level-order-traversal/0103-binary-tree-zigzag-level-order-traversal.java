import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.DelayQueue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    private static interface LevelOrder {
        List<Integer> traverse(Deque<TreeNode> nodes);
    }

    static LevelOrder ltrTraverser = nodes -> {
        int size = nodes.size();
        List<Integer> level = new LinkedList<>();
        while (size-- > 0) {
            TreeNode curr = nodes.removeFirst();

            if (curr.left != null)
                nodes.addLast(curr.left);

            if (curr.right != null)
                nodes.addLast(curr.right);

            level.add(curr.val);
        }

        return level;
    };

    static final LevelOrder rtlTraverser = nodes -> {
        int size = nodes.size();
        List<Integer> level = new LinkedList<>();
        while (size-- > 0) {
            TreeNode curr = nodes.removeLast();

            if (curr.right != null)
                nodes.addFirst(curr.right);

            if (curr.left != null)
                nodes.addFirst(curr.left);

            level.add(curr.val);
        }

        return level;
    };

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        if (root == null)
            return traversal;

        Deque<TreeNode> nodes = new ArrayDeque<>();
        nodes.addFirst(root);

        boolean ltr = true;
        while (!nodes.isEmpty()) {

            List<Integer> level = (ltr) 
                ? ltrTraverser.traverse(nodes)
                : rtlTraverser.traverse(nodes);

            ltr = !ltr;
            traversal.add(level);
        }

        return traversal;
    }
}