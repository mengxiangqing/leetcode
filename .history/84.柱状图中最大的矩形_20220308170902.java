import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solutio {
    // public int largestRectangleArea(int[] heights) {
    // int max = 0;
    // int n = heights.length;
    // if (n == 1)
    // return heights[0];
    // Deque<Integer> stack = new ArrayDeque<>();
    // for (int i = 0; i < n; i++) {
    // while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
    // int current_h = heights[stack.pollLast()];
    // int current_w;
    // if (stack.isEmpty()) {
    // current_w = i;
    // } else {
    // current_w = i - stack.peekLast() - 1;
    // }

    // max = Math.max(max, (current_h * current_w));
    // }

    // stack.addLast(i);
    // }
    // while (!stack.isEmpty()) {
    // int current_h = heights[stack.pollLast()];
    // int current_w;
    // if (stack.isEmpty()) {
    // current_w = n;
    // } else {
    // current_w = n - stack.peekLast() - 1;
    // }

    // max = Math.max(max, (current_h * current_w));
    // }

    // return max;
    // }
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        // 在数组首尾添加0，方便确定边界
        // stack.addLast(0);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            // 栈顶元素小于新元素heights[i]
            if (heights[stack.getLast()] <= heights[i]) {
                // 进栈
                stack.addLast(i);
            } else {
                // 新元素小于栈顶元素，出栈，并计算面积
                while (stack.getLast() > heights[i]) {
                    int curH = stack.pollLast();
                    max = Math.max(max, heights[curH] * (i - curH));
                }
                //新元素进栈
                stack.addLast(i);
            }
        }
        return max;

    }
}
// @lc code=end
