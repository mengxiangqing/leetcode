/*
 * @lc app=leetcode.cn id=427 lang=java
 *
 * [427] 建立四叉树
 */

/*
// Definition for a QuadTree node.
*/
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

/**
 *
 class Solution {
 */
class foooo {
    // @lc code=start
    public Node construct(int[][] grid) {
        Node root = create(grid, 0, 0, grid.length);

        return root;

    }

    /**
     *
     * @param grid
     * @param i    起始行坐标
     * @param j    起始列坐标
     * @param x    边长
     * @return
     */
    public static Node create(int[][] grid, int i, int j, int x) {
        Node root = new Node();
        if (x == 1) {
            root.val = grid[i][j] == 0 ? false : true;
            root.isLeaf = true;
        } else {
            root.topLeft = create(grid, i, j, x / 2);
            root.bottomLeft = create(grid, i + x / 2, j, x / 2);
            root.topRight = create(grid, i, j + x / 2, x / 2);
            root.bottomRight = create(grid, i + x / 2, j + x / 2, x / 2);
            if ((root.topLeft.val && root.topRight.val && root.bottomLeft.val && root.bottomRight.val)
                    || (!root.topLeft.val && !root.topRight.val && !root.bottomLeft.val && !root.bottomRight.val)) {
                root.isLeaf = true;
                root.val = root.topRight.val;
                root.bottomLeft = null;
                root.bottomRight = null;
                root.topLeft = null;
                root.topRight = null;
            } else {
                root.isLeaf = false;
                root.val = true;
            }
        }
        return root;
    }
}
// @lc code=end
