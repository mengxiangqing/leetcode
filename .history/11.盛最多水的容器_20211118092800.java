/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        // 双重循环超时

        int left = 0;
        int right = height.length - 1;

        // 可以往里缩
        // 当前水量
        int num = (height[right] < height[left] ? height[right] : height[left]) * (right - left);
        // 左边往里移动一格之后的水量
        int num_left = (height[right] < height[left + 1] ? height[right] : height[left + 1]) * (right - left - 1);
        // 右边往里移动一格之后的水量
        int num_right = (height[right - 1] < height[left] ? height[right - 1] : height[left]) * (right - left - 1);
        while (num < num_left && left + 1 < right) {
            left++;
            // 当前水量
            num = (height[right] < height[left] ? height[right] : height[left]) * (right - left);
            // 左边往里移动一格之后的水量
            num_left = (height[right] < height[left + 1] ? height[right] : height[left + 1]) * (right - left - 1);
        }
        while (num < num_right && left < right - 1) {
            right--;
            // 当前水量
            num = (height[right] < height[left] ? height[right] : height[left]) * (right - left);
            // 右边往里移动一格之后的水量
            num_right = (height[right - 1] < height[left] ? height[right - 1] : height[left]) * (right - left - 1);

        }
        return (height[right] < height[left] ? height[right] : height[left]) * (right - left);

    }
}
// @lc code=end
