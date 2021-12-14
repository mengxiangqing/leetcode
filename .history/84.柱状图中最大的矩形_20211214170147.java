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
                if(heights[j]>=heights[i]&&i)
            }
        }
        return max;
    }
}
// @lc code=end

