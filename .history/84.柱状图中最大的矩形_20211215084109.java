import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int n = heights.length;
        if (n == 1)
            return heights[0];
        Deque<Integer> stack = new ArrayDeque<>();
        
        return max;
    }

}
// @lc code=end
