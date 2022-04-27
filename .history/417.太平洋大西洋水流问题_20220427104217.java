import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=417 lang=java
 *
 * [417] 太平洋大西洋水流问题
 */

// @lc code=start
class Solution {
    // leftTop[i][j]表示能否流向左上边,0 未赋值，1 可以，2 不可以
    private boolean[][] canReachP;
    // 表示能否流向右下边
    private boolean[][] canReachX;

    // private static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    // 用的时候


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        canReachP = new boolean[m][n];
        canReachX = new boolean[m][n];
        // 从海边出发，看能到达哪里
        for (int i = 0; i < m; i++) {
            exploer(i, 0, heights, canReachP);
            exploer(i, n - 1, heights, canReachX);
        }
        for (int j = 0; j < n; j++) {
            exploer(0, j, heights, canReachP);
            exploer(m - 1, j, heights, canReachX);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachP[i][j] && canReachX[i][j])
                    res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }

    public static void exploer(int i, int j, int[][] heights, boolean[][] canReach) {
        // for (int[] d : direction) {

        // }
        if (canReach[i][j])
            return;
        canReach[i][j] = true;

        if (i - 1 >= 0 && heights[i - 1][j] >= heights[i][j])
            exploer(i - 1, j, heights, canReach);
        if (j - 1 >= 0 && heights[i][j - 1] >= heights[i][j])
            exploer(i, j - 1, heights, canReach);
        if (i + 1 < heights.length && heights[i + 1][j] >= heights[i][j])
            exploer(i + 1, j, heights, canReach);
        if (j + 1 < heights[0].length && heights[i][j + 1] >= heights[i][j])
            exploer(i, j + 1, heights, canReach);
    }
}
// @lc code=end
