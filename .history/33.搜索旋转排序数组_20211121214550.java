/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target)
                return 0;
            else
                return -1;
        }
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[0] < nums[mid]) {// 小于就是mid取到了大的那一部分
                // 去找target在哪边
                if (target < nums[mid] && nums[0] <= target) {// 在左边
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
        return -1;
    }
}
// @lc code=end
