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
            num = 0;
            //向前
            int l = i;
            while (l >= 0) {
                if (heights[l] >= heights[i])
                    num++;
                else
                    break;
                l--;
            }
            int r = i + 1;
            while (r < heights.length) {
                if (heights[r] >= heights[i]) {
                    num++;
                } else
                    break;
                r++;
            }
            max = Math.max(heights[i] * num, max);
        }
        return max;
    }

}
// @lc code=end
