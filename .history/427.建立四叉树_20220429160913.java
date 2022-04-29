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
        return dfs(0, 0, g.length - 1, g.length - 1);

    }

    private Node dfs(int a, int b, int an, int bn) {
        boolean ok = true;
        int temp = g[a][b];
        for (int i = a; i <= an; i++) {
            for (int j = b; j <= bn; j++) {
                if (g[i][j] != temp) {
                    ok = false;
                    break;
                }
            }
        }
        if (ok)
            return new Node(temp == 1, true);
        Node root = new Node(temp == 1, false);
        int dx = an - a + 1;
        int dy = bn - b + 1;
        root.topLeft = dfs(a, b, a + dx / 2 + 1, b + dy / 2 + 1);
        root.topRight = dfs(a, b + dy / 2, a + dx / 2 + 1, bn);
        root.bottomLeft = dfs(a + dx / 2, b, an, b + dy / 2 + 1);
        root.bottomRight = dfs(a + dx / 2, b + dy / 2, an, bn);
        return root;
    }

}
// @lc code=end
