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
        int res = 0;

        // 可以往里缩
        while (left < right) {

            // 当前水量
            int area = (height[right] < height[left] ? height[right] : height[left]) * (right - left);
            res = res > area ? res : area;
            if (height[left]<height[right]) {
                left++;
            } else
                right--;
        }
        return res;
    }
}
// @lc code=end
