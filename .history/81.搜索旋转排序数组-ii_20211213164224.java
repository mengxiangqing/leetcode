/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target)
                return true;
            else
                return false;
        }
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                r--;
                l++;
            } else if (nums[l] <= nums[mid]) {// 小于就是mid取到了大的那一部分，注意等号
                // 去找target在哪边
                if (target < nums[mid] && nums[l] <= target) {// 在左边
                    r = mid - 1;
                } else
                    l = mid + 1;
            } else {
                // 取到了小的那一部分,去找target
                if (nums[n - 1] >= target && target > nums[mid]) {
                    l = mid + 1;
                } else
                    r = mid - 1;
            }
        }

        return false;
    }
}
// @lc code=end

