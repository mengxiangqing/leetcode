import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=154 lang=java
 *
 * [154] 寻找旋转排序数组中的最小值 II
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        if (nums[low] < nums[high])
            return nums[low];
        while (low < high && nums[0] == nums[high])
            high--;
        while (low < high) {
            int mid = low + high + 1 >> 1;
            if (nums[mid] >= nums[0]) {
                low = mid;
            }
            else
                high = mid - 1;

        }
        return high + 1 < n ? nums[high + 1] : nums[0];
    }
}
// @lc code=end
