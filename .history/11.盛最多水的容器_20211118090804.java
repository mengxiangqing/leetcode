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
        while (left < right) {
            // 可以往里缩
            if (height[left] + 1 < height[left + 1] && left + 1 < right) {
                left++;
            } else if (height[right] + 1 < height[right - 1] && left < right - 1) {
                right--;
            } else {
                break;
            }

        }
        return (height[right] < height[left] ? height[right] : height[left]) * (right - left);

    }
}
// @lc code=end
