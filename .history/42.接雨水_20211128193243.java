/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = height[i] > max ? height[i] : max;
        }
        // 一共max层，一层一层来处理
        int ceng = 1;
        while (ceng <= max) {
            // 先找开头和结尾
            int start = 0;
            int end = height.length;
            for (int i = 0; i < height.length; i++) {
                if (height[i] != 0) {
                    start = i;
                    break;
                }
            }
            for (int i = height.length - 1; i >= 0; i--) {
                if (height[i] != 0) {
                    end = i;
                    break;
                }
            }
            if (start < end) {
                for (int i = start; i < end; i++) {
                    if (height[i] == 0) {
                        sum += 1;
                    }
                }
                for (int i = 0; i < height.length; i++) {
                    height[i] = height[i] - 1 < 0 ? 0 : height[i] - 1;
                }
            } else {
                break;
            }

        }
        return sum;
    }
}
// @lc code=end
