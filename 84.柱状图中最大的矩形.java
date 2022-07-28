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
        Deque<Integer> stack = new ArrayDeque<>();
        // 在数组首尾添加0，方便确定边界
        int[] newheights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newheights, 1, heights.length);
        // 先将哨兵放入栈，就不用判断非空了
        stack.addLast(0);
        int max = 0;
        for (int i = 1; i < newheights.length; i++) {
            // 单调递增栈，遇到比栈顶小的就出栈
            while (newheights[stack.getLast()] > newheights[i]) {
                int curH = newheights[stack.removeLast()];
                int curW = i -( stack.getLast() + 1);
                max = Math.max(max, curH * curW);
            }
            stack.addLast(i);
        }
        return max;

    }
}
// @lc code=end
