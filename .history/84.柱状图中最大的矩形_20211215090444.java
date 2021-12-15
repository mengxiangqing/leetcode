import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solutio {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int n = heights.length;
        if (n == 1)
            return heights[0];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int wide = stack.pollLast();
                max = Math.max(max, (i - wide) * heights[wide]);
            }

            stack.addLast(i);
        }
        return max;
    }

}
// @lc code=end
