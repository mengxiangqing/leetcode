/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        // 双重循环超时

        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            //可以往里缩
            if (height[left] + (right - left) < height[left + 1]) {
                left++;
            }
            else if (height[right] + (right - left) < height[right - 1]) {
                right--;
            }
            else {
                break;
            }
            
        }
        int num = (height[right] < height[left] ? height[right] : height[left]) * (right - left);
        max = num > max ? num : max;

        return max;

    }
}
// @lc code=end
