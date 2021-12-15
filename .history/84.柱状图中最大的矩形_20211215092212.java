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
                int current_h = heights[stack.pollLast()];
                int current_w;
                if (stack.isEmpty()) {
                    current_w = i;
                } else {
                    current_w = i - stack.peekLast() - 1;
                }

                max = Math.max(max, (i - current_h * current_w));
            }

            stack.addLast(i);
        }
        while (!stack.isEmpty()) {
            int current_h = heights[stack.pollLast()];
            int current_w;
            if (stack.isEmpty()) {
                current_w = n;
            } else {
                current_w = n - stack.peekLast() - 1;
            }

            max = Math.max(max, (n - current_h * current_w));
        }

        return max;
    }

}
// @lc code=end
