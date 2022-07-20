/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    int[] p;
    int res;

    int find(int i) {
        if (p[i] == i)
            return p[i];
        return p[i] = find(p[i]);
    }

    void union(int i, int j) {
        if (find(i) == find(j)) {
            return; // 避免重复合并操作
        }
        p[find(i)] = p[find(j)];
        res--;
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        res = 0;
        p = new int[m * n];

        // 初始化parent数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                p[idx] = idx;
                if (grid[i][j] == '1') {
                    res++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                if (grid[i][j] == '1') {
                    // 合并岛屿，从左上角开始检查右 和 下。
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        union(idx, (i + 1) * n + j);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        union(idx, i * n + j + 1);
                    }

                }
            }
        }

        return res;

    }

}
// @lc code=end
