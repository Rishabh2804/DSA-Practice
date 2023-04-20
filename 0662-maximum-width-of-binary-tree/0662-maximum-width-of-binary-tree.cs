    public class Pair
    {
        public TreeNode node;
        public int id;

        public Pair(TreeNode Key, int Value)
        {
            this.node = Key;
            this.id = Value;
        }
    }
    public class Solution
    {
        public int WidthOfBinaryTree(TreeNode root)
        {
            if (root == null)
                return 0;

            int maxWidth = 0;
            Queue<Pair> nodes = new Queue<Pair>();
            nodes.Enqueue(new Pair(root, 0));

            while (nodes.Count > 0)
            {
                int size = nodes.Count;
                int left = int.MaxValue;
                int right = int.MinValue;

                while (size > 0)
                {
                    Pair curr = nodes.Dequeue();
                    left = Math.Min(left, curr.id);
                    right = Math.Max(right, curr.id);

                    if (curr.node.left != null)
                        nodes.Enqueue(new Pair(curr.node.left, 2 * curr.id + 1));
                    if (curr.node.right != null)
                        nodes.Enqueue(new Pair(curr.node.right, 2 * curr.id + 2));

                    size--;
                }

                maxWidth = Math.Max(maxWidth, right - left + 1);
            }

            return maxWidth;
        }
    }