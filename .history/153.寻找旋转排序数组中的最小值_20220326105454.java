/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = nums[left];
        while (left <= right) {
            // min = Math.min(min, nums[left]);
            int mid = (right - left) / 2 + left;
            // 前半部分
            if (nums[mid] > min) {
                right = mid - 1;
            } else
                left = mid + 1;
        }
        // int mid = (right - left) / 2 + left;
        min = Math.min(min, nums[left]);
        return min;
    }
}
// @lc code=end
