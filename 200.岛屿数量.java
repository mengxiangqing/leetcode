import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int numOfLands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    numOfLands++;
                    // dfs(grid, i, j);
                    grid[i][j] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(i * n + j);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / n;
                        int col = id % n;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * n + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < m && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * n + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * n + col - 1);
                            grid[row][col - 1] = '0';

                        }
                        if (col + 1 < n && grid[row][col + 1] == '1') {
                            neighbors.add(row * n + col + 1);
                            grid[row][col + 1] = '0';

                        }

                    }
                }

            }
        }

        return numOfLands;

    }

    // dfs，深度优先遍历，将遇到的岛屿都变成海
    public void dfs(char[][] grid, int ix, int jx) {
        int m = grid.length;
        int n = grid[0].length;
        if (ix < 0 || jx < 0 || ix >= m || jx >= n || grid[ix][jx] == '0') {
            return;
        }
        grid[ix][jx] = '0';
        dfs(grid, ix - 1, jx);
        dfs(grid, ix + 1, jx);
        dfs(grid, ix, jx - 1);
        dfs(grid, ix, jx + 1);
    }
}
// @lc code=end
