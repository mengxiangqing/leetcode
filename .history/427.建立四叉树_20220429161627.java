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

// @lc code=start
/**
 * class foooo {
 *
 */
class Solution {
    int[][] g;

    public Node construct(int[][] grid) {
        g = grid;
        return dfs(0, 0, g.length);

    }

    private Node dfs(int a, int b, int size) {
        if (size == 1)
            return new Node(g[a][b] == 1, true);
        int subSize = size / 2;
        Node topLeft = dfs(a, b, subSize);
        Node topRight = dfs(a, b + subSize, subSize);
        Node bottomLeft = dfs(a + subSize, b, subSize);
        Node bottomRight = dfs(a + subSize, b + subSize, subSize);
        if (topLeft.isLeaf && topRight.isLeaf && bottomRight.isLeaf && bottomLeft.isLeaf && topRight.val == topLeft.val
                && topLeft.val == bottomLeft.val && bottomLeft.val == bottomRight.val)
            return new Node(topLeft.val, true);
        else {
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }

}
// @lc code=end
