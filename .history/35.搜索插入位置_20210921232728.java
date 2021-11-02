/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public static int searchInsert(int[] nums, int target) {

        int high = nums.length - 1;
        int low = 0;
        if (nums[0] >= target)
            return 0;
        else {
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target)
                    return mid;
                else if (target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

        }

        return low;
    }
}
// @lc code=end
