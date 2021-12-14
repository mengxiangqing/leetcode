/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int num = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights.length; j++) {
                if (heights[j] >= heights[i] && isLin(i, j, heights)) {
                    num++;
                }
            }
            max = Math.max(heights[i] * num, max);
        }
        return max;
    }

    private boolean isLin(int i, int j, int[] heights) {
        if (i == j)
            return true;

        int l = i > j ? j : i;
        int r = i < j ? j : i;
        for (int k = l; k <= r; k++) {
            if (heights[k] < heights[i]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
