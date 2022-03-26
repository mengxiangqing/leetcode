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
        if (nums[left] < nums[right])
            return nums[left];
        while (left <= right) {
            // min = Math.min(min, nums[left]);
            int mid = (right - left) / 2 + left;
            // 前半部分
            if (nums[mid] < nums[right]) {
                right = mid;
            } else
                left = mid + 1;
        }
        return nums[left];

    }
}
// @lc code=end
