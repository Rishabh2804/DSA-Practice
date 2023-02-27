/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return construct(0, grid.length - 1, 0, grid[0].length - 1, grid);
    }

    public boolean identical(boolean... bs) {
        if (bs.length <= 1)
            return true;

        boolean first = bs[0];
        for (boolean b : bs) {
            if (b != first)
                return false;
        }

        return true;
    }

    public Node construct(int si, int ei, int sj, int ej, int[][] grid) {
        int n = ei - si + 1;
        if (n == 1)
            return new Node(grid[si][sj] == 1, true);

        Node topLeft = construct(si, si - 1 + n / 2, sj, sj - 1 + n / 2, grid);
        Node topRight = construct(si, si - 1 + n / 2, sj + n / 2, ej, grid);
        Node bottomLeft = construct(si + n / 2, ei, sj, sj - 1 + n / 2, grid);
        Node bottomRight = construct(si + n / 2, ei, sj + n / 2, ej, grid);

        boolean req1 = topLeft.isLeaf && topRight.isLeaf &&
                bottomLeft.isLeaf && bottomRight.isLeaf;
        boolean req2 = identical(topLeft.val, topRight.val, bottomLeft.val, bottomRight.val);
        if (req1 && req2)
            return new Node(topLeft.val, true);
        else
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}