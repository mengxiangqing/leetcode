import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 */

// @lc code=start
class Solution {

  public int maximalRectangle(char[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int max = 0;

    int[] heights = new int[cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
      }
      max = Math.max(max, maxArea(heights));
    }
    return max;
  }

  public int maxArea(int[] nums) {
    int max = 0;
    int len = nums.length;
    int[] heights = new int[len + 2];
    System.arraycopy(nums, 0, heights, 1, len);
    Deque<Integer> stack = new ArrayDeque<>();
    stack.addFirst(0);
    for (int i = 1; i < heights.length; i++) {
      while (heights[stack.getFirst()] > heights[i]) {
        int curH = heights[stack.removeFirst()];
        int curW = i - stack.getFirst() - 1;
        max = Math.max(max, curH * curW);
      }
      stack.addFirst(i);
    }
    return max;
  }
}
// @lc code=end
